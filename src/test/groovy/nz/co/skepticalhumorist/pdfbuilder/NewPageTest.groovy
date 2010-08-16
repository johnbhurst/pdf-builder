package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import de.oio.jpdfunit.document.util.TextSearchType

class NewPageTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("Page 1")
      newPage()
      paragraph("Page 2")
      newPage()
      paragraph("Page 3")
    }
    defaultTester.with {
      assertContentContainsTextOnPage("Page 1", 1, TextSearchType.CONTAINS)
      assertContentContainsTextOnPage("Page 2", 2, TextSearchType.CONTAINS)
      assertContentContainsTextOnPage("Page 3", 3, TextSearchType.CONTAINS)
    }
  }

}
