package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import de.oio.jpdfunit.document.util.TextSearchType

class NewPageTest extends AbstractPDFBuilderTestCase {

  @Test
  void testUsingNewPageMethod() {
    defaultBuilder.document() {
      paragraph("Page 1")
      document.newPage()
      paragraph("Page 2")
      document.newPage()
      paragraph("Page 3")
    }
    defaultTester.with {
      assertContentContainsTextOnPage("Page 1", 1, TextSearchType.CONTAINS)
      assertContentContainsTextOnPage("Page 2", 2, TextSearchType.CONTAINS)
      assertContentContainsTextOnPage("Page 3", 3, TextSearchType.CONTAINS)
    }
  }

}
