package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Paragraph
import de.oio.jpdfunit.document.util.TextSearchType

class SectionTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      chapter(1) {
        paragraph("First paragraph.")
        section("Section 1.1") {
          paragraph("Section paragraph 1.1.")
          section("Section 1.1.1") {
            paragraph("Section paragraph 1.1.1.")
          }
        }
      }
      chapter(title: "Chapter II", number: 2) {
        paragraph("Second paragraph.")
      }
    }
    defaultTester.assertContentContainsText("First paragraph.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Section paragraph 1.1.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Section paragraph 1.1.1.", TextSearchType.CONTAINS)
    // could put assertions on section titles in text ...
  }

}
