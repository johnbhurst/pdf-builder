package nz.co.skepticalhumorist.pdfbuilder

import de.oio.jpdfunit.document.util.TextSearchType
import org.junit.Test

class DottedLineSeparatorTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("A paragraph.")
      dottedLineSeparator()
      paragraph("Another paragraph.")
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
  }

}
