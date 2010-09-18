@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/InvisibleRectangles.pdf")).document() {
  paragraph("Two paths for identical rectangles are constructed, but we forgot to paint them.")
  writer.directContent.with {
    moveTo(30, 700)
    lineTo(490, 700)
    lineTo(490, 800)
    lineTo(30, 800)
    closePath()
    rectangle(30, 700, 460, 100)
  }
}
