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
    if (value instanceof String) {
      return value
    }
    else {
      return super.newInstance(builder, name, value, attributes)
    }
  }

}
