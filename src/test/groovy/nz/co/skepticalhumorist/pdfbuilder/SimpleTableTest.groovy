package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test

class SimpleTableTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    new PDFBuilder(outputStream: new File(tmpDir, "SimpleTableTest.pdf").newOutputStream()).document() {
      table(2, spacingBefore: 15, spacingAfter: 30) {
        cell(paragraph("cell 1,1")); cell(paragraph("cell 1,2"))
        cell(paragraph("cell 2,1")); cell(paragraph("cell 2,2"))
      }
    }
  }

}
