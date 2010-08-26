package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable

class TableFactory extends AbstractElementFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    PdfPTable result = new PdfPTable(value)
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

  def void setParent(FactoryBuilderSupport builder, Object parent, Object child) {
    //println("TableFactory.setParent($builder, $parent, $child)") // Add DEBUG message?
//    parent.addCell(child)
  }

  def void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
    //println("TableFactory.setChild($builder, $parent, (${child.class}) $child)") // Add DEBUG message?
//    if (child.class == PdfPCell) {
//      parent.addCell(child)
//    }
  }

//  def void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    //println("TableFactory.onNodeCompleted($builder, $parent, $node)") // Add DEBUG message?
//    parent.add(node)
//  }

}
