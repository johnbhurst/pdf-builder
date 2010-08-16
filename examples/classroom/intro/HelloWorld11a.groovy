@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Graphics2D
import com.lowagie.text.pdf.PdfContentByte
import static com.lowagie.text.PageSize.A4

def RESULT = "build/examples/classroom/intro/hello11a.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  writer.directContent.with {PdfContentByte cb ->
    cb.withGraphicsShapes(A4.width, A4.height) {Graphics2D graphics ->
      graphics.drawString("Hello World", 36, 54)
    }
  }
}
