package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.Image
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.PdfPTable

class CellFactory extends ElementFactory {

  CellFactory() {
    elementClass = PdfPCell
    ctorArgTypes = [
      [phrase: Phrase],
      [image: Image, fit: boolean],
      [image: Image],
      [table: PdfPTable, style: PdfPCell],
      [table: PdfPTable],
      [cell: PdfPCell]
    ]
  }

  @Override
  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    // If called with a String, this does not match any PdfPCell constructor.
    // Instead we make a special case of this.
    // We return the String for PdfPTable.addCell(String), and ignore any other attributes.
    // No PdfPCell is actually created.  The table's defaultCell is used instead.
    // Nested content is invalid.
    if (value instanceof String) {
      return value
    }
    else {
      return super.newInstance(builder, name, value, attributes)
    }
  }

}
