@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.PageSize
import com.lowagie.text.pdf.PdfContentByte
import java.awt.Color

/**
 * This example repeats the one shown in MultiColumnIrregular, but using the onEndPage event to
 * draw the graphics on each page.
 * This way the text part is done very simply and naturally using the "normal" PDFBuilder way
 * of adding elements, rather than having to call document.add(mct) and mct.nextColumn()
 * in a loop.
 */
def RESULT= "build/examples/in_action/chapter07/MultiColumnIrregular2.pdf"
def INPUT = System.getProperty("itext.examples.home") + "/resources/in_action/chapter07/caesar.txt"
float diamondHeight = 400
float diamondWidth = 400
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4, onEndPage: {writer, document ->
  float centerX = (document.right() - document.left()) / 2 + document.left() as float
  float bodyHeight = document.top() - document.bottom() as float
  float diamondTop = document.top() - ((bodyHeight - diamondHeight) / 2f) as float
  writer.withDirectContent {PdfContentByte cb ->
    cb.lineWidth = 5
    cb.colorStroke = Color.GRAY
    cb.moveTo(centerX, document.top())
    cb.lineTo(centerX, document.bottom())
    cb.stroke()
    cb.moveTo(centerX, diamondTop)
    cb.lineTo(centerX - (diamondWidth / 2) as float, diamondTop - (diamondHeight / 2) as float)
    cb.lineTo(centerX, diamondTop - diamondHeight as float)
    cb.lineTo(centerX + (diamondWidth / 2) as float, diamondTop - (diamondHeight / 2) as float)
    cb.lineTo(centerX, diamondTop)
    cb.colorFill = Color.GRAY
    cb.fill()
  }
}) {
  multiColumnText(alignment: Element.ALIGN_JUSTIFIED, init: {
    float gutter = 10
    float bodyHeight = document.top() - document.bottom() as float
    float colMaxWidth = (document.right() - document.left() - (gutter * 2)) / 2f as float
    float diamondTop = document.top() - ((bodyHeight - diamondHeight) / 2f) as float
    float diamondInset = colMaxWidth - (diamondWidth / 2f) as float
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
    addColumn(left, right)
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
    addColumn(left, right)
  }) {
    new File(INPUT).eachLine {line ->
      phrase("$line\n")
    }
  }
}
