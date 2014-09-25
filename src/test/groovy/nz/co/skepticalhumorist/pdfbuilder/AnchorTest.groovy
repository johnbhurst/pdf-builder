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

class AnchorTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph {
        anchor("Quick brown fox jumps over the lazy dog.", reference: "http://en.wikipedia.org/wiki/The_quick_brown_fox_jumps_over_the_lazy_dog")
      }
      paragraph() {
        chunk("Quick brown ")
        anchor("fox", reference: "#fox")
        chunk(" jumps over the lazy dog.")
      }
      document.newPage()
      anchor("This is the FOX.", name: "fox")
    }
    defaultTester.assertContentContainsTextMultipleTimes("Quick brown", TextSearchType.CONTAINS)
  }

}
