package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.pdf.PdfDocument
import com.lowagie.text.pdf.PdfWriter
import static com.lowagie.text.PageSize.A4
import de.oio.jpdfunit.document.util.TextSearchType
import java.awt.Graphics2D

class DirectContentGraphicsTest extends AbstractPDFBuilderTestCase {

  @Test
  public void testDirectConent() {
    defaultBuilder.document(
      onOpenDocument: {PdfWriter writer, PdfDocument document ->
        writer.withDirectContentGraphics(A4.width, A4.height) {Graphics2D graphics ->
          graphics.drawString("Hello World Over", 36, 54)
        }
      }
    ) {
    }
    defaultTester.with {
      assertContentContainsTextOnPage("Hello World Over", 1, TextSearchType.CONTAINS)
    }
  }

  @Test
  public void testDirectContentUnder() {
    defaultBuilder.document(
      onOpenDocument: {PdfWriter writer, PdfDocument document ->
        writer.withDirectContentUnderGraphics(A4.width, A4.height) {Graphics2D graphics ->
          graphics.drawString("Hello World Under", 36, 54)
        }
      }
    ) {
    }
    defaultTester.with {
      assertContentContainsTextOnPage("Hello World Under", 1, TextSearchType.CONTAINS)
    }
  }


}
