@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.PageSize
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable

// PDF-Builder not naturally suited to this example.
// Creating 3 documents with the same table, but slightly different configuration.
def largeTable(PdfPTable current) {
  String text = ". Quick brown fox jumps over the lazy dog."
  PdfPCell largeCell = new PdfPCell()
  for (i in 1..12) {
    largeCell.addElement(new Paragraph("$i$text"))
  }
  for (i in 1..10) {
    current.addCell("$i")
    current.addCell(largeCell)
    if (i == 8) {
      for (j in 13..30) {
        largeCell.addElement(new Paragraph("$j$text"))
      }
    }
  }
}

def RESULT1= "build/examples/in_action/chapter06/SplitRowsBetween.pdf"
def RESULT2= "build/examples/in_action/chapter06/SplitRowsWithin.pdf"
def RESULT3= "build/examples/in_action/chapter06/OmitRows.pdf"
new PDFBuilder(new FileOutputStream(RESULT1)).document(PageSize.A4.rotate()) {
  table(2) {largeTable(current)}
}
new PDFBuilder(new FileOutputStream(RESULT2)).document(PageSize.A4.rotate()) {
  table(2, splitLate: false) {largeTable(current)}
}
new PDFBuilder(new FileOutputStream(RESULT3)).document(PageSize.A4.rotate()) {
  table(2, splitLate: false, splitRows: false) {largeTable(current)}
}
