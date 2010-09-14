@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Image

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/FoxDogImageChunk.pdf")).document() {
  paragraph("Quick brown ") {
    chunk(image: Image.getInstance(imageLocation("fox.gif")), offsetX: 0, offsetY: -15)
    chunk(" jumps over the lazy ")
    chunk(image: Image.getInstance(imageLocation("dog.gif")), offsetX: 0, offsetY: -15)
    chunk(".")
  }
}
