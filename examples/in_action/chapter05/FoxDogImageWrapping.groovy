@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Image
import com.lowagie.text.Phrase

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/FoxDogImageWrapping.pdf")).document() {
  Phrase p = new Phrase("Quick brown fox jumps over the lazy dog. ")
  image(imageLocation("foxdog.jpg"), alignment: Image.RIGHT | Image.TEXTWRAP)
  20.times {document.add(p)}
  image(imageLocation("foxdog.gif"), alignment: Image.MIDDLE | Image.UNDERLYING)
  30.times {document.add(p)}
}
