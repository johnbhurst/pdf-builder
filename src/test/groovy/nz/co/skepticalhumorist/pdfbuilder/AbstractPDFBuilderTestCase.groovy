package nz.co.skepticalhumorist.pdfbuilder

import org.junit.After
import org.junit.AfterClass
import org.junit.BeforeClass
import de.oio.jpdfunit.DocumentTester

class AbstractPDFBuilderTestCase {

  static File tmpDir

  private DocumentTester defaultTester

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
    if (this.defaultTester == null) {
      this.defaultTester = new DocumentTester(defaultFile.newInputStream())
    }
    this.defaultTester
  }

  @After
  void closeResources() {
    if (this.defaultTester != null) {
      this.defaultTester.close()
    }
  }

}
