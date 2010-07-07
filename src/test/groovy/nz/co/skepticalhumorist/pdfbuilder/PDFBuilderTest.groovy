package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import java.awt.Color
import com.itextpdf.text.Font
import com.itextpdf.text.Document

class PDFBuilderTest {
  @Test
  void testOk() {
    new File("tryme.pdf").withOutputStream {outputStream ->
      def document = new PDFBuilder(outputStream: outputStream).document() {
        image(filename: "images/LowagieBook.png")
        paragraph(string: "First paragraph")
//        paragraph(string: "Invoice", font: new Font(Font.HELVETICA, 16, Font.BOLD, Color.BLACK))
      }
      assert document.class == Document
    }
  }

}

