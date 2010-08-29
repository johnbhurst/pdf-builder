@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.PageSize
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.ColumnText
import com.lowagie.text.Image
import com.lowagie.text.pdf.PdfTemplate

def RESULT= "build/examples/in_action/chapter07/ColumnsIrregular.pdf"
def INPUT = System.getProperty("itext.examples.home") + "/resources/in_action/chapter07/caesar.txt"
Image caesar = Image.getInstance(System.getProperty("itext.examples.home") + "/resources/in_action/chapter07/caesar.jpg")
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4) {
  String text = new File(INPUT).text
  writer.directContent.addImage(caesar, 100, 0, 0, 100, 260, 595)
  PdfTemplate template = writer.directContent.addTemplate(600, 800, 0, 0) {PdfTemplate t ->
    t.grayFill = 0.75f
    t.moveTo(310, 112)
    t.lineTo(280, 60)
    t.lineTo(340, 60)
    t.closePath()
    t.moveTo(310, 790)
    t.lineTo(310, 710)
    t.moveTo(310, 580)
    t.lineTo(310, 122)
    t.fillStroke()
  }
  ColumnText ct = new ColumnText(writer.directContent)
  ct.alignment = Element.ALIGN_JUSTIFIED
  ct.setText(new Phrase(text))
  def left = [
    [70, 790, 70, 60] as float[],
    [320, 790, 320, 700, 380, 700, 380, 590, 320, 590, 320, 106, 350, 60] as float[]
  ]
  def right = [
    [300, 790, 300, 700, 240, 700, 240, 590, 300, 590, 300, 106, 270, 60] as float[],
    [550, 790, 550, 60] as float[]
  ]
  int status = ColumnText.START_COLUMN
  int column = 0
  while (ColumnText.hasMoreText(status)) {
    if (column > 1) {
      column = 0
      document.newPage()
      writer.directContent.addTemplate(template, 0, 0)
      writer.directContent.addImage(caesar, 100, 0, 0, 100, 260, 595)
    }
    ct.setColumns(left[column], right[column])
    ct.YLine = 790
    status = ct.go()
    column++
  }
}
