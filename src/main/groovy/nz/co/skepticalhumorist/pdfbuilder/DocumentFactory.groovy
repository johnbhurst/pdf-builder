package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Document
import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.pdf.PdfPTable
import org.codehaus.groovy.runtime.DefaultGroovyMethods
import com.lowagie.text.Rectangle
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
    DefaultGroovyMethods.mixin(document.metaClass, PdfCategory)
    pageEvent.properties.each {key, val ->
      if (attributes.containsKey(key)) {
        pageEvent[key] = attributes.remove(key)
      }
    }
    writer = PdfWriter.getInstance(document, builder.outputStream)
    DefaultGroovyMethods.mixin(writer.metaClass, PdfCategory)
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
