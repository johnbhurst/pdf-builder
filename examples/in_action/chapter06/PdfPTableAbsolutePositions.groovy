@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfPRow
import com.lowagie.text.pdf.PdfPTable

def RESULT= "build/examples/in_action/chapter06/PdfPTableAbsolutePositions.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  PdfContentByte cb = writer.directContent
  PdfPTable table = new PdfPTable(2)
  table.setTotalWidth([50, 250] as float[])
  for (k in 0..199) {
    table.addCell("row $k")
    table.addCell("blah blah blah $k")
  }
  paragraph("row 0 - 50")
  table.writeSelectedRows(0, 50, 150, 820, cb)
  document.newPage()
  paragraph("row 50 - 100")
  table.writeSelectedRows(50, 100, 150, 820, cb)
  document.newPage()
  paragraph("row 100 - 150 DOESN'T FIT ON THE PAGE!!!")
  table.writeSelectedRows(100, 150, 150, 200, cb)
  document.newPage()
  paragraph("row 150 - 200")
  table.writeSelectedRows(150, -1, 150, 820, cb)
  println "Total table height: ${table.totalHeight}"
  float rowheight = 0;
  for (i in 0..49) {
    rowheight += table.getRowHeight(i)
  }
  println "Height of the first 50 rows: $rowheight"
  print "Heights of the individual rows:"
  table.rows.each {PdfPRow row ->
    print " ${row.maxHeights}"
  }
}
