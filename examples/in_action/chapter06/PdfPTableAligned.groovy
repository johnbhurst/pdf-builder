@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Paragraph
import com.lowagie.text.Element

def RESULT= "build/examples/in_action/chapter06/PdfPTableAligned.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  def t = table(3, widthPercentage: 100) {
    cell(new Paragraph("header with colspan 3"), colspan: 3)
    current.with {
      addCell("1.1"); addCell("2.1"); addCell("3.1")
      addCell("1.2"); addCell("2.2"); addCell("3.2")
    }
  }
  t.widthPercentage = 50
  t.horizontalAlignment = Element.ALIGN_RIGHT
  current.add(t)
  t.horizontalAlignment = Element.ALIGN_LEFT
  current.add(t)
}
