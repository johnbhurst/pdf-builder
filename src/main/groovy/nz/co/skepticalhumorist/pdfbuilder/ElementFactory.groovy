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

import com.lowagie.text.pdf.MultiColumnText
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import org.codehaus.groovy.runtime.InvokerHelper

class ElementFactory extends AbstractFactory {

  Class elementClass
  List ctorArgTypes

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    def ctorArgs = getArgs(attributes, value)
    def result = createInstance(builder, ctorArgs)
    if (attributes.containsKey("init")) {
      Closure init = attributes.remove("init")
      init(result)
    }
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

  def createInstance(FactoryBuilderSupport builder, ctorArgs) {
    return InvokerHelper.invokeConstructorOf(elementClass, ctorArgs)
  }

  def getArgs(Map attributes, value) {
    return PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
  }

  @Override
  void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    switch (parent) {
      case MultiColumnText: parent.addElement(node); break;
      case PdfPCell: parent.addElement(node); break;
      case PdfPTable: parent.addCell(node); break;
      default: parent.add(node)
    }
  }

}
