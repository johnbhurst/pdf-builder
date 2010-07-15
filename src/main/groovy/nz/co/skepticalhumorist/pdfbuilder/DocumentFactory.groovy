package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.Document
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.PdfPTable

class DocumentFactory extends AbstractFactory {

  PDFBuilder builder
  Document document

  DocumentFactory(builder) {
    this.builder = builder;
  }

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    document = new Document()
    PdfWriter.getInstance(document, builder.outputStream)
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
    if (child.class != PdfPTable) {
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
