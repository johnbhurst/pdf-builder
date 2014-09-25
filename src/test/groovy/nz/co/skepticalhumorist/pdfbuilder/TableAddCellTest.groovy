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

import com.lowagie.text.Element
import com.lowagie.text.Paragraph
import org.junit.Test

class TableAddCellTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document() {
      table(3, spacingBefore: 15, spacingAfter: 30) {
        cell(colspan: 3) {paragraph(string: "Table Heading", alignment: Element.ALIGN_CENTER)}
        cell("cell 1,1"); cell("cell 1,2"); cell("cell 1,3")
        cell("cell 2,1"); cell("cell 2,2"); cell("cell 2,3")
      }
    }
  }

}
