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

