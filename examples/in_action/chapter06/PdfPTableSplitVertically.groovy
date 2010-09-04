@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfPRow
import com.lowagie.text.pdf.PdfPTable

def RESULT= "build/examples/in_action/chapter06/PdfPTableSplitVertically.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  PdfPTable table = new PdfPTable(10)
  table.totalWidth = 800
  for (k in 1..100) {
    table.addCell("number $k")
  }
  table.writeSelectedRows(0, 5, 0, -1, 50, 650, writer.directContent)
  document.newPage()
  table.writeSelectedRows(5, -1, 0, -1, 50, 650, writer.directContent)
}
