package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Paragraph

class SimpleTableTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document() {
      table(2, spacingBefore: 15, spacingAfter: 30) {
        cell(new Paragraph("cell 1,1")); cell(new Paragraph("cell 1,2"))
        cell(new Paragraph("cell 2,1")); cell(new Paragraph("cell 2,2"))
      }
    }
  }

}
