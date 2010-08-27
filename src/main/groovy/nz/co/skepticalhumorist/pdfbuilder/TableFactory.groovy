package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPTable

class TableFactory extends ElementFactory {

  TableFactory() {
    elementClass = PdfPTable
    ctorArgTypes = [
      [relativeWidths: float[]],
      [numColumns: int],
      [table: PdfPTable]
    ]
  }

}
