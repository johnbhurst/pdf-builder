// Copyright 2014- John Hurst
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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
