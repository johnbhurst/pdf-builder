package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test

class ImageTest {

  @Test
  void testOk() {
    File file = new File("ImageTest.pdf")
    new PDFBuilder(outputStream: file.newOutputStream()).document() {
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
      image("images/LowagieBook.png")
      image(filename: "images/LowagieBook.png")
      image(url: new URL("http://www.itextpdf.com/img/1t3xt.gif"))
    }
  }
}

