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

import org.junit.Test
import com.lowagie.text.Phrase
import de.oio.jpdfunit.document.util.TextSearchType

class TextAndCompositeModeTableTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document() {
      table(2) {
        cell(new Phrase("cell 1,1"))     // should add cell in "text" mode (iText in Action 7.3.1)
        cell() {paragraph("cell 1,2")}   // should add cell in "composite" mode (iText in Action 7.3.2)
      }
    }
    defaultTester.assertContentContainsText("cell 1,1", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("cell 1,2", TextSearchType.CONTAINS)
  }
}
