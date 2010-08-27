package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import de.oio.jpdfunit.document.util.TextSearchType

class AnnotationTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("Paragraph.")
      def an = annotation(title: "Annotation Title", text: "Annotation Text", llx: 10, lly: 10, urx: 10, ury: 10)
      assert an.title() == "Annotation Title"
      assert an.content() == "Annotation Text"
    }
    defaultTester.assertContentContainsText("Paragraph", TextSearchType.CONTAINS)
  }

}
