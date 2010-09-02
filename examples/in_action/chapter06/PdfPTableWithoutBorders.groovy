@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfPCell

def RESULT= "build/examples/in_action/chapter06/PdfPTableWithoutBorders.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  table(3, init: {it.defaultCell.border = PdfPCell.NO_BORDER}) {
    cell(new Paragraph("header with colspan 3"), colspan: 3)
    current.with {
      addCell("1.1"); addCell("2.1"); addCell("3.1")
      addCell("1.2"); addCell("2.2"); addCell("3.2")
    }
  }
}
