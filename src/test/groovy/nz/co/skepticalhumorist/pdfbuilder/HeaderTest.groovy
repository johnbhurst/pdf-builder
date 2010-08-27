package nz.co.skepticalhumorist.pdfbuilder

import de.oio.jpdfunit.document.util.TextSearchType
import org.junit.Test

class HeaderTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      header(name: "PDF_BUILDER", content: "pdf-builder")
      paragraph("A paragraph. ")
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
  }

}
