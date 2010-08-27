package nz.co.skepticalhumorist.pdfbuilder

import de.oio.jpdfunit.document.util.TextSearchType
import org.junit.Test

class PhraseTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("") {
        phrase("")
        phrase("A phrase")
      }
    }
    defaultTester.assertContentContainsText("A phrase", TextSearchType.CONTAINS)
  }
}
