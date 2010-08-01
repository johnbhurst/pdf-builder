package nz.co.skepticalhumorist.pdfbuilder

import org.junit.AfterClass
import org.junit.BeforeClass

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
    tmpDir.deleteDir()
  }

}
