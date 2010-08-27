package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import de.oio.jpdfunit.document.util.TextSearchType

class ParagraphTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("A paragraph. ") {
        def ch = chunk("A chunk.")
        assert ch.getContent() == "A chunk."
      }
    }
    defaultTester.assertContentContainsText("A paragraph. A chunk.", TextSearchType.CONTAINS)
  }

}
