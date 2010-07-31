@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import com.itextpdf.text.BaseColor
import com.itextpdf.text.Font
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder

def HEADING_FONT = new Font(Font.FontFamily.HELVETICA, 16.0f, Font.BOLD, BaseColor.BLACK)
def BOLD_FONT = new Font(Font.FontFamily.HELVETICA, 10.0f, Font.BOLD, BaseColor.BLUE)
new PDFBuilder(outputStream: new File("Sample.pdf").newOutputStream()).document() {
  paragraph(string: "First paragraph")
  paragraph(string: "Second paragraph", font: HEADING_FONT)
  paragraph("Third paragraph")
  table(2, spacingBefore: 15, spacingAfter: 30) {
    cell(paragraph("cell 1,1")); cell(paragraph("cell 1,2"))
    cell(paragraph("cell 2,1")); cell(paragraph("cell 2,2", font: BOLD_FONT))
  }
  table([0.4f, 0.2f, 0.4f] as float[], spacingAfter: 30) {
    cell(paragraph("wider cell")) ; cell(paragraph("10")) ; cell(paragraph("wider cell"))
    cell(paragraph("more cells")) ; cell(paragraph("20")) ; cell(paragraph("more and more"))
    cell(paragraph("finally ...")) ; cell(paragraph("30")) ; cell(paragraph("the end"))
  }
  paragraph(leading: 10.0f, string: "Leading: 10")
  paragraph(leading: 15.0f, string: "Leading: 15", font: BOLD_FONT)
  table([0.5f, 0.5f] as float[]) {
    cell(paragraph(string: "one", font: BOLD_FONT)) ; cell(paragraph("two"))
  }
  newPage()
  paragraph("Next page (1)...")
  newPage()
  paragraph("Next page (2)...")
}

