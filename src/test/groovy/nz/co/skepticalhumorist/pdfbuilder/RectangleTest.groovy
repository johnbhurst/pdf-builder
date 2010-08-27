package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Rectangle
import de.oio.jpdfunit.document.util.TextSearchType

class RectangleTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("A paragraph.")
      rectangle(llx: 10, lly: 10, urx: 100, ury: 100, borderWidth: 5, border: Rectangle.BOX)
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
  }

}
