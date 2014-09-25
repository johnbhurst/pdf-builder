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
import com.lowagie.text.pdf.PdfDocument
import com.lowagie.text.pdf.PdfWriter
import static com.lowagie.text.PageSize.A4
import de.oio.jpdfunit.document.util.TextSearchType
import java.awt.Graphics2D

class DirectContentGraphicsShapesTest extends AbstractPDFBuilderTestCase {

  @Test
  public void testDirectContent() {
    defaultBuilder.document(
      onOpenDocument: {PdfWriter writer, PdfDocument document ->
        writer.directContent.withGraphicsShapes(A4.width, A4.height) {Graphics2D graphics ->
          graphics.drawString("Hello World Over", 36, 54)
        }
      }
    ) {
    }
    defaultTester.with {
      assertContentDoesNotContainText("Hello World Over", TextSearchType.CONTAINS)
    }
  }

  @Test
  public void testDirectContentUnder() {
    defaultBuilder.document(
      onOpenDocument: {PdfWriter writer, PdfDocument document ->
        writer.directContentUnder.withGraphicsShapes(A4.width, A4.height) {Graphics2D graphics ->
          graphics.drawString("Hello World Under", 36, 54)
        }
      }
    ) {
    }
    defaultTester.with {
      assertContentDoesNotContainText("Hello World Under", TextSearchType.CONTAINS)
    }
  }

}
