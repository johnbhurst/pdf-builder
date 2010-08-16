@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Graphics2D
import static com.lowagie.text.PageSize.A4

def RESULT = "build/examples/classroom/intro/hello10.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(
  // This example uses the onOpenDocument event hook to write with the DirectContent layer.
  // It would be better if this layer could be accessed via the main builder block.
  // I.e., it would be more analogous to the iText example.
  // But on the other hand, accessing DirectContent via event hooks might be a more typically real use-case.
  onOpenDocument: {writer, document ->
    writer.directContent.with {cb ->
      Graphics2D graphics2D = cb.createGraphics(A4.width, A4.height)
      graphics2D.drawString("Hello World", 36, 54)
      graphics2D.dispose()
    }
  }
) {
  // nothing in main
}
