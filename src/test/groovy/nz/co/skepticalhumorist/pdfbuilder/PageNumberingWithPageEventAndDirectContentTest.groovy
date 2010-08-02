package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.itextpdf.text.pdf.PdfContentByte
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfDocument
import com.itextpdf.text.pdf.PdfWriter
import de.oio.jpdfunit.document.util.TextSearchType

class PageNumberingWithPageEventAndDirectContentTest extends AbstractPDFBuilderTestCase {

  BaseFont font = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED)

  @Test
  public void testOk() {
    defaultBuilder.document(
      onEndPage: {PdfWriter writer, PdfDocument document ->
        writer.withDirectContent {PdfContentByte cb ->
          cb.beginText()
          cb.setFontAndSize(font, 12)
          cb.setTextMatrix(document.left() as float, document.bottom() - 20 as float)
          cb.showText("Page " + writer.getPageNumber())
          cb.endText()
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
