@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import static Math.sin
import static Math.cos
import static Math.PI

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/FoxDogRawImage.pdf")).document() {
  byte[] imagedata = new File(imageLocation("foxdog.jpg")).bytes
  paragraph("Image constructed with a byte array containing the image data.")
  image(imagedata)

  // creation of an image of 100 x 100 pixels (x 3 bytes for the Red, Green and Blue value)
  byte[] data = new byte[100 * 100 * 3]
  0.upto(99) {k ->
    0.step(300, 3) {j ->
      data[k * 300 + j] = 255 * sin(j * 0.5 * PI / 300) as byte
      data[k * 300 + j + 1] = 256 - j * 256 / 300 as byte
      data[k * 300 + j + 2] = 255 * cos(k * 0.5 * PI / 100) as byte
    }
  }
  paragraph("Image constructed with a byte array of raw image data.")
  image(width: 100, height: 100, components: 3, bpc: 8, data: data)
}
