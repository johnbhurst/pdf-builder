package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Paragraph
import de.oio.jpdfunit.document.util.TextSearchType

class ChapterAutoNumberTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      chapterAutoNumber(title: "Chapter I") {
        paragraph("First paragraph.")
      }
      chapterAutoNumber(title: new Paragraph("Chapter Two"), bookmarkTitle: "Another Story") {
        paragraph("Second paragraph.")
      }
    }
    defaultTester.assertContentContainsText("First paragraph.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Second paragraph.", TextSearchType.CONTAINS)
  }

}
