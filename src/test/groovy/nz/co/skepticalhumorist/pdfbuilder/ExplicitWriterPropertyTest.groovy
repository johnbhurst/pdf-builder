package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.pdf.BaseFont
import de.oio.jpdfunit.document.util.TextSearchType

class ExplicitWriterPropertyTest extends AbstractPDFBuilderTestCase {
  BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("Para 1")
      writer.directContent.withText {cb ->
        cb.moveText(36, 806)
        cb.moveText(0, -54)
        cb.setFontAndSize(bf, 12)
        cb.showText("Direct Content")
      }
      paragraph("Para 2")
    }
    defaultTester.with {
      assertContentContainsText("Para 1", TextSearchType.CONTAINS)
      assertContentContainsText("Para 2", TextSearchType.CONTAINS)
      assertContentContainsText("Direct Content", TextSearchType.CONTAINS)
    }

  }

}
