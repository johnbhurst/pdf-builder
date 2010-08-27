package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Paragraph
import de.oio.jpdfunit.document.util.TextSearchType

class ChapterTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      chapter(1) {
        paragraph("First paragraph.")
      }
      chapter(title: "Chapter II", number: 2) {
        paragraph("Second paragraph.")
      }
      chapter(title: new Paragraph("Chapter Three"), number: 3, bookmarkTitle: "Another Story") {
        paragraph("Third paragraph.")
      }
    }
    defaultTester.assertContentContainsText("First paragraph.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Second paragraph.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Third paragraph.", TextSearchType.CONTAINS)
  }

}
