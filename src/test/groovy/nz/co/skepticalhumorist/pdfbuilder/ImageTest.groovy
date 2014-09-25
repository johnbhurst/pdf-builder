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

class ImageTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      // getInstance(byte[])
      // getInstance(Image)
      // getInstance(Image, Color)
      // getInstance(Image, Color, boolean)
      // getInstance(int, int, boolean, int, int, byte[])
      // getInstance(int, int, boolean, int, int, byte[], byte[])
      // getInstance(int, int, byte[], byte[])
      // getInstance(int, int, int, int, byte[])
      // getInstance(int, int, int, int, byte[], int[])
      // getInstance(PdfContentByte, Image, float)
      // getInstance(PdfTemplate)
      // getInstance(PdfWriter, Image, float)
      // getInstance(PRIndirectReference)
      // getInstance(String)
      // getInstance(URL)
      def img1 = image("images/LowagieBook.png")
      def img2 = image(filename: "images/LowagieBook.png", init: {it.scalePercent(25f)})
      def img3 = image(url: new URL("http://www.itextpdf.com/img/logo.gif"), init: {it.scalePercent(50f, 100f)})
      assert img1.width == 355
      assert img2.width == 355
      assert img2.scaledWidth == 355 / 4
      assert img3.width == 150
      assert img3.scaledWidth == 150 / 2
      assert img3.height == 150
    }
  }
}

