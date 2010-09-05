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
    cell("1.1"); cell("2.1"); cell("3.1")
    cell("1.2"); cell("2.2"); cell("3.2")
  }
}
