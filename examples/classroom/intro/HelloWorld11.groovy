@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Graphics2D
import static com.lowagie.text.PageSize.A4

def RESULT = "build/examples/classroom/intro/hello11.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  writer.directContent.with {cb ->
    Graphics2D graphics2D = cb.createGraphicsShapes(A4.width, A4.height)
    graphics2D.drawString("Hello World", 36, 54)
    graphics2D.dispose()
  }
}
