@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.GrayColor
import com.lowagie.text.pdf.PdfContentByte

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/DirectContent.pdf")).document() {
  def drawLayer = {PdfContentByte cb, float llx, float lly, float w, float h ->
    cb.colorFill = new GrayColor(0.9f)
    cb.colorStroke = new GrayColor(0.2f)
    cb.moveTo(llx, lly)
    cb.lineTo(llx + w / 4 as float, lly + h / 3 as float)
    cb.lineTo(llx + 7 * w / 8 as float, lly + h / 3 as float)
    cb.lineTo(llx + (2 * w) / 3 as float, lly)
    cb.closePathFillStroke()
  }
  writer.directContent.withState {cb -> drawLayer(cb, 70, 750, 150, 100)}
  writer.directContentUnder.withState {cb -> drawLayer(cb, 70, 730, 150, 100)}
  10.times {
    paragraph("quick brown fox ") {
      chunk("jumps", background: new GrayColor(0.5f))
      chunk(" over the lazy dog")
    }
  }
  writer.directContent.withState {cb -> drawLayer(cb, 70, 670, 150, 100)}
  writer.directContentUnder.withState {cb -> drawLayer(cb, 70, 650, 150, 100)}
}
