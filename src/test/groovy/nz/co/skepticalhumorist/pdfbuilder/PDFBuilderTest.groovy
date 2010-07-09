package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.itextpdf.text.BaseColor
import com.itextpdf.text.Document
import com.itextpdf.text.Font

class PDFBuilderTest {
  @Test
  void testOk() {
    def headingFont = new Font(Font.FontFamily.HELVETICA, 16.0f, Font.BOLD, BaseColor.BLACK)
    def boldFont = new Font(Font.FontFamily.HELVETICA, 10.0f, Font.BOLD, BaseColor.BLUE)
    def document = new PDFBuilder(outputStream: new File("tryme.pdf").newOutputStream()).document() {
      image(filename: "images/LowagieBook.png")
      paragraph(string: "First paragraph")
      paragraph("Second paragraph", font: headingFont)
      table(2, spacingBefore: 15, spacingAfter: 30) {
        cell(string: "cell 1,1"); cell(string: "cell 1,2")
        cell("cell 2,1"); cell("cell 2,2", font: boldFont)
      }
      table([0.4f, 0.2f, 0.4f] as float[], spacingAfter: 30) {
        cell("wider cell") ; cell("10") ; cell("wider cell")
        cell("more cells") ; cell("20") ; cell("more and more")
        cell("finally ...") ; cell("30") ; cell("the end")
      }
    }
    assert document.class == Document
  }

}

