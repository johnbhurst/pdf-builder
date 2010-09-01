@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Paragraph

def RESULT= "build/examples/in_action/chapter06/PdfPTableColumnWidths.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  def t = table([1, 1, 2] as float[]) {
    cell(new Paragraph("header with colspan 3"), colspan: 3)
    current.with {
      addCell("1.1"); addCell("2.1"); addCell("3.1")
      addCell("1.2"); addCell("2.2"); addCell("3.2")
    }
  }
  t.widths = [2, 1, 1] as float[]
  current.add(t)
}
