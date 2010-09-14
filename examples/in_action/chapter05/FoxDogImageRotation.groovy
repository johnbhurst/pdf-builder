@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Image

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/FoxDogImageRotation.pdf")).document() {
  Image jpg1 = Image.getInstance(imageLocation("foxdog.jpg"))
  jpg1.scalePercent(80)
  jpg1.rotation = Math.PI / 6 as float
  paragraph("rotate 30 degrees")
  document.add(jpg1)
  paragraph("Original width: ${jpg1.width}; original height: ${jpg1.height}")
  paragraph("Plain width: ${jpg1.plainWidth}; plain height: ${jpg1.plainHeight}")
  paragraph("Scaled width: ${jpg1.scaledWidth}; scaled height: ${jpg1.scaledHeight}")
  document.newPage()
  Image jpg2 = Image.getInstance(imageLocation("foxdog.jpg"))
  jpg2.rotationDegrees = 45
  paragraph("rotate 45 degrees")
  document.add(jpg2)
  jpg2.rotation = Math.PI / 2
  paragraph("rotate pi/2 radians")
  document.add(jpg2)
  document.newPage()
  jpg2.rotationDegrees = 135
  paragraph("rotate 135 degrees")
  document.add(jpg2)
  jpg2.rotation = Math.PI
  paragraph("rotate pi radians")
  document.add(jpg2)
  document.newPage()
  jpg2.rotation = 2.0 * Math.PI
  paragraph("rotate 2 x pi radians")
  document.add(jpg2)
}
