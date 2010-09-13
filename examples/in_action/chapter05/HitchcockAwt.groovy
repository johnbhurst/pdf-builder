@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Toolkit
import com.lowagie.text.Rectangle

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}
Rectangle rect = new Rectangle(200, 280)
java.awt.Image awtImage =
  Toolkit.getDefaultToolkit().createImage(imageLocation("hitchcock.png"))

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/HitchcockAwt1.pdf")).document(rect) {
  image(imageLocation("hitchcock.png"), init: {it.setAbsolutePosition(15, 15)})
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/HitchcockAwt2.pdf")).document(rect) {
  image(awtImage: awtImage, color: null, init: {it.setAbsolutePosition(15, 15)})
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/HitchcockAwt100.pdf")).document(rect) {
  image(writer: writer, awtImage: awtImage, quality: 1, init: {it.setAbsolutePosition(15, 15)})
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/HitchcockAwt20.pdf")).document(rect) {
  image(writer: writer, awtImage: awtImage, quality: 0.2, init: {it.setAbsolutePosition(15, 15)})
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/HitchcockAwt10.pdf")).document(rect) {
  image(writer: writer, awtImage: awtImage, quality: 0.1, init: {it.setAbsolutePosition(15, 15)})
}
