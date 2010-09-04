@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Element
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfPTable
import com.lowagie.text.pdf.PdfPCell

def RESULT= "build/examples/in_action/chapter06/PdfPTableNested.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  table(4) {
    def table = current
    PdfPTable nested1 = new PdfPTable(2)
    nested1.addCell("1.1")
    nested1.addCell("1.2")
    PdfPTable nested2 = new PdfPTable(1)
    nested2.addCell("20.1")
    nested2.addCell("20.2")
    for (int k in 0..23) {
      if (k == 1) {
        table.addCell(nested1)
      }
      else if (k == 20) {
        cell(nested2)
      }
      else {
        table.addCell("cell $k")
      }
    }
  }
}
