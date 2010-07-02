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
//        image(url: "http://www.skepticalhumorist.co.nz/images/AscentOfHumorist_500x150.png")
//        paragraph(string: "Invoice", font: new Font(Font.HELVETICA, 16, Font.BOLD, Color.BLACK))
      }
      assert document.class == Document
    }
  }

}

