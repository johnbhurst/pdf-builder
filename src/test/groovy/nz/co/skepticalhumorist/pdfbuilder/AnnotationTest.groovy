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
import de.oio.jpdfunit.document.util.TextSearchType

class AnnotationTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("Paragraph.")
      def an = annotation(title: "Annotation Title", text: "Annotation Text", llx: 10, lly: 10, urx: 10, ury: 10)
      assert an.title() == "Annotation Title"
      assert an.content() == "Annotation Text"
    }
    defaultTester.assertContentContainsText("Paragraph", TextSearchType.CONTAINS)
  }

}
