package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.itextpdf.text.Document

class PDFBuilderTest {
  @Test
  void testOk() {
    def document = new PDFBuilder(outputStream: new File("tryme.pdf").newOutputStream()).document() {
      image(filename: "images/LowagieBook.png")
      paragraph(string: "First paragraph")
      paragraph("Second paragraph")
      table(numColumns: 2) {
        cell(string: "cell 1,1"); cell(string: "cell 1,2")
        cell("cell 2,1"); cell("cell 2,2")
      }
    }
    assert document.class == Document
  }

}

