@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Image

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/FoxDogImageMask.pdf")).document() {
  def circledata = [0x3c, 0x7e, 0xe7, 0xc3, 0xc3, 0xe7, 0x7e, 0x3c] as byte[]
  Image mask = Image.getInstance(8, 8, 1, 1, circledata)
  mask.makeMask()
  mask.inverted = true
  Image img = Image.getInstance(imageLocation("foxdog.jpg"))
  img.imageMask = mask
  paragraph("The masked image:")
  document.add(img)
  paragraph("The raw image:")
  image(width: 8, height: 8, components: 1, bpc: 1, data: circledata)
  paragraph("The image mask (inverted):")
  document.add(mask)
}
