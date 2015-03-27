// Copyright 2015- John Hurst
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

import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfPCell
import org.junit.Test

class ReflectionUtilsTest {

  @Test
  void testSetProperty() {
    Paragraph paragraph = new Paragraph()
    ReflectionUtils.setProperty(paragraph, "alignment", 1)
    assert paragraph.alignment == 1
    ReflectionUtils.setProperty(paragraph, "alignment", "right")
    assert paragraph.alignment == 2
  }

  @Test
  void testSetFloatProperty() {
    PdfPCell cell = new PdfPCell()
    ReflectionUtils.setProperty(cell, "indent", 1.5)
    assert cell.indent == (1.5).floatValue()
  }

}
