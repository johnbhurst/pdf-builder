package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Document
import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.pdf.PdfPTable
import org.codehaus.groovy.runtime.DefaultGroovyMethods

class DocumentFactory extends AbstractFactory {

  Document document
  PdfWriter writer
  ClosurePdfPageEvent pageEvent = new ClosurePdfPageEvent()

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    document = new Document()
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

  def void setParent(FactoryBuilderSupport builder, Object parent, Object child) {
    //println("DocumentFactory.setParent($builder, $parent, $child)") // Add DEBUG message?
//    if (child.class != PdfTable) {
//      parent.add(child)
//    }
  }

  def void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
    //println("DocumentFactory.setChild($builder, $parent, $child)") // Add DEBUG message?
    if (child instanceof DocumentCommand) {
      child.applyTo(document)
    }
//    else if (child.class != PdfPTable) {
//      parent.add(child)
//    }
  }

  def void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    //println("DocumentFactory.onNodeCompleted($builder, $parent, $node)")
    
    if (parent == null) {
      document.close()
    }
  }

}
