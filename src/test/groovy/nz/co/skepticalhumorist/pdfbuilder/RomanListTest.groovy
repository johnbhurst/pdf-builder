package nz.co.skepticalhumorist.pdfbuilder

import de.oio.jpdfunit.document.util.TextSearchType
import org.junit.Test

class RomanListTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("A paragraph. ") {
        romanList {
          for (i in 1..3) {
            listItem("Item $i.")
          }
        }
      }
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Item 1.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Item 2.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Item 3.", TextSearchType.CONTAINS)
  }

}
