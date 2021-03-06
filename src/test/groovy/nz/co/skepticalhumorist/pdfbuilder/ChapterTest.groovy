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
import com.lowagie.text.Paragraph
import de.oio.jpdfunit.document.util.TextSearchType

class ChapterTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      chapter(1) {
        paragraph("First paragraph.")
      }
      chapter(title: "Chapter II", number: 2) {
        paragraph("Second paragraph.")
      }
      chapter(title: new Paragraph("Chapter Three"), number: 3, bookmarkTitle: "Another Story") {
        paragraph("Third paragraph.")
      }
    }
    defaultTester.assertContentContainsText("First paragraph.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Second paragraph.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Third paragraph.", TextSearchType.CONTAINS)
  }

}
