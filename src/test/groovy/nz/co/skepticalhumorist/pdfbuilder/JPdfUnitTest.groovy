package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import de.oio.jpdfunit.DocumentTester
import de.oio.jpdfunit.document.util.TextSearchType

class JPdfUnitTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    File file = new File(tmpDir, "SimpleTest.pdf")
    new PDFBuilder(outputStream: file.newOutputStream()).document() {
      paragraph("One paragraph")
    }
    new DocumentTester(file.newInputStream()).with {
      assertContentContainsText("One", TextSearchType.CONTAINS)
      assertPageCountEquals 1
    }
    file.delete()
  }
}
