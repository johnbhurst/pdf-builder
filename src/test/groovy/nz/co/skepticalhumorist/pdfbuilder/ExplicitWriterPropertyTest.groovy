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
import com.lowagie.text.pdf.BaseFont
import de.oio.jpdfunit.document.util.TextSearchType

class ExplicitWriterPropertyTest extends AbstractPDFBuilderTestCase {
  BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph("Para 1")
      writer.directContent.withText {cb ->
        cb.moveText(36, 806)
        cb.moveText(0, -54)
        cb.setFontAndSize(bf, 12)
        cb.showText("Direct Content")
      }
      paragraph("Para 2")
    }
    defaultTester.with {
      assertContentContainsText("Para 1", TextSearchType.CONTAINS)
      assertContentContainsText("Para 2", TextSearchType.CONTAINS)
      assertContentContainsText("Direct Content", TextSearchType.CONTAINS)
    }

  }

}
