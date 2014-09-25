// Copyright 2014- John Hurst
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Document
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.PdfWriter
import org.codehaus.groovy.runtime.InvokerHelper

class DocumentFactory extends AbstractFactory {

  def ctorArgTypes = [
    [pageSize: Rectangle, marginLeft: float, marginRight: float, marginTop: float, marginBottom: float],
    [pageSize: Rectangle]
  ]

  Document document
  PdfWriter writer
  ClosurePdfPageEvent pageEvent = new ClosurePdfPageEvent()

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    def ctorArgs = PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
    document = InvokerHelper.invokeConstructorOf(Document, ctorArgs)
    document.metaClass.mixin(PdfCategory)
    pageEvent.properties.each {key, val ->
      if (attributes.containsKey(key)) {
        pageEvent[key] = attributes.remove(key)
      }
    }
    writer = PdfWriter.getInstance(document, builder.outputStream)
    writer.metaClass.mixin(PdfCategory)
    writer.setPageEvent(pageEvent)
    if (attributes.containsKey("initWriter")) {
      Closure initWriter = attributes.remove("initWriter")
      initWriter.delegate = writer
      initWriter()
    }
    if (attributes.containsKey("initDocument")) {
      Closure initDocument = attributes.remove("initDocument")
      initDocument.delegate = document
      initDocument()
    }
    document.open()
    return document
  }

  def void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    if (parent == null) {
      document.close()
    }
  }

}
