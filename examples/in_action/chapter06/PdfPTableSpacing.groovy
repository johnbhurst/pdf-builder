@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Paragraph

def RESULT= "build/examples/in_action/chapter06/PdfPTableSpacing.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  paragraph("We add 2 tables:")
  def t = table(3) {
    cell(new Paragraph("header with colspan 3"), colspan: 3)
    cell("1.1"); cell("2.1"); cell("3.1")
    cell("1.2"); cell("2.2"); cell("3.2")
  }
  document.add(t)
  paragraph("They are glued to eachother. The table that follows, is glued to this text.")
  document.add(t)
  paragraph("This is not very nice. Let's define a certain 'SpacingBefore':")
  t.spacingBefore = 15
  document.add(t)
  document.add(t)
  paragraph("We can also increase the spacing after every table.")
  t.spacingAfter = 10
  document.add(t)
  paragraph("This is better, don't you think so?")
}
