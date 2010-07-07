package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.pdf.PdfPTable

class TableFactory extends AbstractFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    if (attributes.containsKey("numColumns")) {
      int numColumns = attributes.remove("numColumns")
      return new PdfPTable(numColumns)
    }
    return null
  }

  def void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
    parent.addCell(child)
  }

  def void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    println("TableFactory.onNodeCompleted($builder, $parent, $node)")
    parent.add(node)
  }

}
