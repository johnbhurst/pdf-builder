@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.PageSize
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.MultiColumnText
import java.awt.Color

def RESULT= "build/examples/in_action/chapter07/MultiColumnIrregular.pdf"
def INPUT = System.getProperty("itext.examples.home") + "/resources/in_action/chapter07/caesar.txt"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4) {
  MultiColumnText mct = new MultiColumnText(document.top() - document.bottom() as float)
  mct.alignment = Element.ALIGN_JUSTIFIED
  float diamondHeight = 400
  float diamondWidth = 400
  float gutter = 10
  float bodyHeight = document.top() - document.bottom() as float
  float colMaxWidth = (document.right() - document.left() - (gutter * 2)) / 2f as float
  float diamondTop = document.top() - ((bodyHeight - diamondHeight) / 2f) as float
  float diamondInset = colMaxWidth - (diamondWidth / 2f) as float
  float centerX = (document.right() - document.left()) / 2 + document.left() as float
  // setup column 1
  def left = [
    document.left(),
    document.top(),
    document.left(),
    document.bottom()
  ] as float[]
  def right = [
    document.left() + colMaxWidth,
    document.top(),
    document.left() + colMaxWidth,
    diamondTop,
    document.left() + diamondInset,
    diamondTop - diamondHeight / 2,
    document.left() + colMaxWidth,
    diamondTop - diamondHeight,
    document.left() + colMaxWidth,
    document.bottom()
  ] as float[]
  mct.addColumn(left, right)
  // setup column 2
  left = [
    document.right() - colMaxWidth,
    document.top(),
    document.right() - colMaxWidth,
    diamondTop,
    document.right() - diamondInset,
    diamondTop - diamondHeight / 2,
    document.right() - colMaxWidth,
    diamondTop - diamondHeight,
    document.right() - colMaxWidth,
    document.bottom()
  ] as float[]
  right = [
    document.right(),
    document.top(),
    document.right(),
    document.bottom()
  ] as float[]
  mct.addColumn(left, right)
  new File(INPUT).eachLine {line ->
    mct.addElement(new Phrase("$line\n"))
  }
  while (true) {
    writer.directContent.with {
      lineWidth = 5
      colorStroke = Color.GRAY
      moveTo(centerX, document.top())
      lineTo(centerX, document.bottom())
      stroke()
      moveTo(centerX, diamondTop)
      lineTo(centerX - (diamondWidth / 2) as float, diamondTop - (diamondHeight / 2) as float)
      lineTo(centerX, diamondTop - diamondHeight as float)
      lineTo(centerX + (diamondWidth / 2) as float, diamondTop - (diamondHeight / 2) as float)
      lineTo(centerX, diamondTop)
      colorFill = Color.GRAY
      fill()
    }
    document.add(mct)
    mct.nextColumn()
    if (!mct.overflow) {
      break
    }
  }
}
