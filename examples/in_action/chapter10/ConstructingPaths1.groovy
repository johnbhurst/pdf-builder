@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.GrayColor

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/ConstructingPaths1.pdf")).document() {
  writer.directContent.with {
    setColorStroke(new GrayColor(0.2f))
    setColorFill(new GrayColor(0.9f))
    moveTo(30, 700)
    lineTo(130, 700)
    lineTo(130, 800)
    lineTo(30, 800)
    stroke()
    moveTo(140, 700)
    lineTo(240, 700)
    lineTo(240, 800)
    lineTo(140, 800)
    closePathStroke()
    moveTo(250, 700)
    lineTo(350, 700)
    lineTo(350, 800)
    lineTo(250, 800)
    fill()
    moveTo(360, 700)
    lineTo(460, 700)
    lineTo(460, 800)
    lineTo(360, 800)
    fillStroke()
    moveTo(470, 700)
    lineTo(570, 700)
    lineTo(570, 800)
    lineTo(470, 800)
    closePathFillStroke()
  }
}
