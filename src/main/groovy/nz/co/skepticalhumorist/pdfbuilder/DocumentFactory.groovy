package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.Document
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.PdfPTable

class DocumentFactory extends AbstractFactory {

  Document document
  PdfWriter writer
  ClosurePdfPageEvent pageEvent = new ClosurePdfPageEvent()

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    document = new Document()
    pageEvent.properties.each {key, val ->
      if (attributes.containsKey(key)) {
        pageEvent[key] = attributes.remove(key)
      }
    }
    writer = PdfWriter.getInstance(document, builder.outputStream)
    writer.setPageEvent(pageEvent)
    document.open()
    return document
  }

  def void setParent(FactoryBuilderSupport builder, Object parent, Object child) {
    println("DocumentFactory.setParent($builder, $parent, $child)")
//    if (child.class != PdfTable) {
//      parent.add(child)
//    }
  }

  def void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
    println("DocumentFactory.setChild($builder, $parent, $child)")
    if (child instanceof DocumentCommand) {
      child.applyTo(document)
    }
    else if (child.class != PdfPTable) {
      parent.add(child)
    }
  }

  def void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    println("DocumentFactory.onNodeCompleted($builder, $parent, $node)")
    if (parent == null) {
      document.close()
    }
  }

}
