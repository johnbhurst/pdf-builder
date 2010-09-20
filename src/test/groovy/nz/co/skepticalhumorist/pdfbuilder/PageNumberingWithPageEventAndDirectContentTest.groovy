package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.pdf.PdfDocument
import com.lowagie.text.pdf.PdfWriter
import de.oio.jpdfunit.document.util.TextSearchType

class PageNumberingWithPageEventAndDirectContentTest extends AbstractPDFBuilderTestCase {

  BaseFont font = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED)

  @Test
  public void testOk() {
    defaultBuilder.document(
      onEndPage: {PdfWriter writer, PdfDocument document ->
        writer.directContent.withText {PdfContentByte cb ->
          cb.setFontAndSize(font, 12)
          cb.setTextMatrix(document.left() as float, document.bottom() - 20 as float)
          cb.showText("Page " + writer.getPageNumber())
        }
      }
    ) {
      100.times {i ->
        paragraph("Paragraph $i.")
      }
    }
    defaultTester.with {
      assertContentContainsTextOnPage("Page 1", 1, TextSearchType.CONTAINS)
      assertContentContainsTextOnPage("Page 2", 2, TextSearchType.CONTAINS)
    }
  }
}
