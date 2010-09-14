@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Image

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/FoxDogImageScaling1.pdf")).document() {
  Image jpg = Image.getInstance(imageLocation("foxdog.jpg"))
  jpg.scaleAbsolute(154, 94)
  paragraph("scaleAbsolute(154, 94)")
  document.add(jpg)
  jpg.scalePercent(50)
  paragraph("scalePercent(50)")
  document.add(jpg)
  jpg.scaleAbsolute(308, 94)
  paragraph("scaleAbsolute(320, 120)")
  document.add(jpg)
  jpg.scalePercent(100, 50)
  paragraph("scalePercent(100, 50)")
  document.add(jpg)
}
