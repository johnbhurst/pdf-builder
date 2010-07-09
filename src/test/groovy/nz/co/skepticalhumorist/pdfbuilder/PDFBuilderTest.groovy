package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.itextpdf.text.BaseColor
import com.itextpdf.text.Document
import com.itextpdf.text.Font

class PDFBuilderTest {
  @Test
  void testOk() {
    def document = new PDFBuilder(outputStream: new File("tryme.pdf").newOutputStream()).document() {
      image(filename: "images/LowagieBook.png")
      paragraph(string: "First paragraph")
      paragraph("Second paragraph", font: new Font(Font.FontFamily.HELVETICA, 16.0f, Font.BOLD, BaseColor.BLACK))
      table(numColumns: 2) {
        cell(string: "cell 1,1"); cell(string: "cell 1,2")
        cell("cell 2,1"); cell("cell 2,2", font: new Font(Font.FontFamily.HELVETICA, 10.0f, Font.BOLD, BaseColor.BLUE))
      }
    }
    assert document.class == Document
  }

}

