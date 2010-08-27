package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Rectangle
import de.oio.jpdfunit.document.util.TextSearchType

class RectangleReadOnlyTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("A paragraph.")
      def rect = new Rectangle(10, 10, 100, 100)
      rect.borderWidth = 5
      rect.border = Rectangle.BOX
      rectangleReadOnly(rect: rect)
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
  }

}
