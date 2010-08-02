package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test

class SimpleTableTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document() {
      table(2, spacingBefore: 15, spacingAfter: 30) {
        cell(paragraph("cell 1,1")); cell(paragraph("cell 1,2"))
        cell(paragraph("cell 2,1")); cell(paragraph("cell 2,2"))
      }
    }
  }

}
