package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Phrase
import de.oio.jpdfunit.document.util.TextSearchType

class TextAndCompositeModeTableTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document() {
      table(2) {
        cell(new Phrase("cell 1,1"))     // should add cell in "text" mode (iText in Action 7.3.1)
        cell() {paragraph("cell 1,2")}   // should add cell in "composite" mode (iText in Action 7.3.2)
      }
    }
    defaultTester.assertContentContainsText("cell 1,1", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("cell 1,2", TextSearchType.CONTAINS)
  }
}
