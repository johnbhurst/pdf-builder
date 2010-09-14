@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Image

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/FoxDogImageScaling2.pdf")).document() {
  Image tiff = Image.getInstance(imageLocation("foxdog.tiff"))
  document.add(tiff)
  paragraph("Original width: ${tiff.width}; original height: ${tiff.height}")
  paragraph("DPI X: ${tiff.dpiX}; DPI Y: ${tiff.dpiY}")
  tiff.scalePercent(72 / tiff.dpiX * 100 as float)
  paragraph("Show the image with 360 Dpi (scaled ${7200 / tiff.dpiX as float}%):")
  document.add(tiff)
  paragraph("Scaled width: ${tiff.scaledWidth}; scaled height: ${tiff.scaledHeight}")
  tiff.scaleToFit(200, 200)
  document.add(tiff)
  paragraph("Scaled width: ${tiff.scaledWidth}; scaled height: ${tiff.scaledHeight}")
  paragraph("DPI X: ${72 * tiff.width / tiff.scaledWidth as float}; DPI Y: ${72 * tiff.height / tiff.scaledHeight as float}")

}
