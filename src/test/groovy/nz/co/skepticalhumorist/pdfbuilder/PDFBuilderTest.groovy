package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Document
import com.lowagie.text.Font
import java.awt.Color

class PDFBuilderTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    def HEADING_FONT = new Font(Font.HELVETICA, 16.0f, Font.BOLD, Color.BLACK)
    def BOLD_FONT = new Font(Font.HELVETICA, 10.0f, Font.BOLD, Color.BLUE)
    def document = defaultBuilder.document() {
      image(filename: "images/LowagieBook.png")
      paragraph(string: "First paragraph")
      paragraph(string: "Second paragraph", font: HEADING_FONT)
      paragraph("Third paragraph")
      table(2, spacingBefore: 15, spacingAfter: 30) {
        cell(paragraph("cell 1,1")); cell(paragraph("cell 1,2"))
        cell(paragraph("cell 2,1")); cell(paragraph("cell 2,2", font: BOLD_FONT))
      }
      table([0.4f, 0.2f, 0.4f] as float[], spacingAfter: 30) {
        cell(paragraph("wider cell")) ; cell(paragraph("10")) ; cell(paragraph("wider cell"))
        cell(paragraph("more cells")) ; cell(paragraph("20")) ; cell(paragraph("more and more"))
        cell(paragraph("finally ...")) ; cell(paragraph("30")) ; cell(paragraph("the end"))
      }
      paragraph(leading: 10.0f, string: "Leading: 10")
      paragraph(leading: 15.0f, string: "Leading: 15", font: BOLD_FONT)
      table([0.5f, 0.5f] as float[]) {
        cell(paragraph(string: "one", font: BOLD_FONT)) ; cell(paragraph("two"))
      }
      newPage()
      paragraph("Next page (1)...")
      newPage()
      paragraph("Next page (2)...")
    }
    assert document.class == Document
  }

}

