package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import de.oio.jpdfunit.DocumentTester
import de.oio.jpdfunit.document.util.TextSearchType

class JPdfUnitTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("One paragraph")
    }
    defaultTester.with {
      assertContentContainsText("One", TextSearchType.CONTAINS)
      assertPageCountEquals 1
    }
  }
}
