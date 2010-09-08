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

    // Note that PdfPTable also has these other addCell() variants:
    //   addCell(Phrase)
    //   addCell(Image)
    //   addCell(PdfPTable)
    // In each of these cases the object is added via addCell(defaultCell).
    // Also, for each of these cases, there is also an analagous PdfPCell constructor.
    // Thus, having cell() node support for these cases like this support for String would be
    // ambiguous.
    // Note though that
    //   addCell(phrase)
    // is different from
    //   addCell(new PdfPCell(phrase)), == cell(phrase)
    if (value instanceof String || value instanceof GString) {
      return value
    }
    else {
      return super.newInstance(builder, name, value, attributes)
    }
  }

}
