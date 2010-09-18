@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.GrayColor

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/ConstructingPaths3.pdf")).document() {
  writer.directContent.with {
    float x0, y0, x1, y1, x2, y2, x3, y3
    x0 = 30
    y0 = 720
    x1 = 40
    y1 = 790
    x2 = 100
    y2 = 810
    x3 = 120
    y3 = 750
    moveTo(x0, y0)
    lineTo(x1, y1)
    moveTo(x2, y2)
    lineTo(x3, y3)
    moveTo(x0, y0)
    curveTo(x1, y1, x2, y2, x3, y3)
    x0 = 180
    y0 = 720
    x2 = 250
    y2 = 810
    x3 = 270
    y3 = 750
    moveTo(x2, y2)
    lineTo(x3, y3)
    moveTo(x0, y0)
    curveTo(x2, y2, x3, y3)
    x0 = 330
    y0 = 720
    x1 = 340
    y1 = 790
    x3 = 420
    y3 = 750
    moveTo(x0, y0)
    lineTo(x1, y1)
    moveTo(x0, y0)
    curveTo(x1, y1, x3, y3)
    stroke()
  }
}
