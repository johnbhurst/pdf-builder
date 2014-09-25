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

import de.oio.jpdfunit.document.util.TextSearchType
import org.junit.Test

class GreekListTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("A paragraph. ") {
        greekList {
          for (i in 1..3) {
            listItem("Item $i.")
          }
        }
      }
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Item 1.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Item 2.", TextSearchType.CONTAINS)
    defaultTester.assertContentContainsText("Item 3.", TextSearchType.CONTAINS)
  }

}
