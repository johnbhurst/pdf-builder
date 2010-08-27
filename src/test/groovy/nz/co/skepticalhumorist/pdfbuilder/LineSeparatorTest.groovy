package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import de.oio.jpdfunit.document.util.TextSearchType

class LineSeparatorTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("A paragraph.")
      lineSeparator()
      paragraph("Another paragraph.")
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
  }

}
