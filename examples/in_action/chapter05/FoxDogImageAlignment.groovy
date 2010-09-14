@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Image

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/FoxDogImageAlignment.pdf")).document() {
  phrase("foxdog.jpg")
  image(imageLocation("foxdog.jpg"), alignment: Image.LEFT)
  phrase("foxdog.gif")
  image(imageLocation("foxdog.gif"), alignment: Image.MIDDLE)
  phrase("foxdog.png")
  image(imageLocation("foxdog.png"), alignment: Image.RIGHT)
}
