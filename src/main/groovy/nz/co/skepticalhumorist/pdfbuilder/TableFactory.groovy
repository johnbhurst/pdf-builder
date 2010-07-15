package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable

class TableFactory extends AbstractFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    PdfPTable result = new PdfPTable(value)
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

  def void setParent(FactoryBuilderSupport builder, Object parent, Object child) {
    println("TableFactory.setParent($builder, $parent, $child)")
//    parent.addCell(child)
  }

  def void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
    println("TableFactory.setChild($builder, $parent, (${child.class}) $child)")
    if (child.class == PdfPCell) {
      parent.addCell(child)
    }
  }

  def void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    println("TableFactory.onNodeCompleted($builder, $parent, $node)")
    parent.add(node)
  }

}
