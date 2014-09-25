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

class MetaTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      // We include meta() here, but the item goes in the document as "unknown(pdf-builder)".
      // The iText Meta JavaDoc states:
      //   An object of type Meta can not be constructed by the user.
      // Meta is reserved for certain particular iText tags.
      // Users use Header to insert other tags.
      meta(tag: "PDF_BUILDER", content: "pdf-builder")
      paragraph("A paragraph. ")
    }
    defaultTester.assertContentContainsText("A paragraph.", TextSearchType.CONTAINS)
  }

}
