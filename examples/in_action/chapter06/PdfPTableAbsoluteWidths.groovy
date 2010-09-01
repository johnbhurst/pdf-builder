@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Paragraph
import com.lowagie.text.PageSize
import com.lowagie.text.Rectangle

def RESULT= "build/examples/in_action/chapter06/PdfPTableAbsoluteWidths.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  float[] widths = [72, 72, 144] as float[]
  Rectangle r = new Rectangle(PageSize.A4.getRight(72), PageSize.A4.getTop(72))
  table(3) {
    current.setWidthPercentage(widths, r)
    cell(new Paragraph("header with colspan 3"), colspan: 3)
    current.with {
      addCell("1.1"); addCell("2.1"); addCell("3.1")
      addCell("1.2"); addCell("2.2"); addCell("3.2")
    }
  }
}
