package nz.co.skepticalhumorist.pdfbuilder

import org.junit.AfterClass
import org.junit.BeforeClass
import de.oio.jpdfunit.DocumentTester

class AbstractPDFBuilderTestCase {

  static File tmpDir

  @BeforeClass
  static void setUp() {
    tmpDir = new File("build/output")
    if (!tmpDir.exists()) {
      tmpDir.mkdirs()
    }
  }

  @AfterClass
  static void tearDown() {
    // Is it better to delete the output documents, or leave em there to examine?
    //tmpDir.deleteDir()
  }

  File getDefaultFile() {
    new File(tmpDir, getClass().getSimpleName() + ".pdf")
  }

  PDFBuilder getDefaultBuilder() {
    new PDFBuilder(defaultFile.newOutputStream())
  }

  DocumentTester getDefaultTester() {
    new DocumentTester(defaultFile.newInputStream())
  }

}
