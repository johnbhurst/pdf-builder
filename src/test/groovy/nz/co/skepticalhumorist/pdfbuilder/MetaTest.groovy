package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import de.oio.jpdfunit.document.util.TextSearchType

class MetaTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      // We include meta() here, but the item goes in the document as "unknown(pdf-builder)".
      // The iText Meta JavaDoc states:
      //   An object of type Meta can not be constructed by the user.
      // Meta is reserved for certain particular iText tags.
      // Users use Header to insert other tags.
      meta(tag: "PDF_BUILDER", content: "pdf-builder")
      paragraph("A paragraph. ")
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
  }

}
