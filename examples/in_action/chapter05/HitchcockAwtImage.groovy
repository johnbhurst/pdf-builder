@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import java.awt.Toolkit
import com.lowagie.text.PageSize
import com.lowagie.text.Rectangle

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

Rectangle rect = new Rectangle(PageSize.A4)
rect.backgroundColor = new Color(0xC0, 0xC0, 0xC0)
new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/HitchcockAwtImage.pdf")).document(rect) {
  java.awt.Image awtImage =
    Toolkit.getDefaultToolkit().createImage(imageLocation("hitchcock.gif"))
  paragraph("Hitchcock in Red.")
  image(awtImage: awtImage, color: null)
  paragraph("Hitchcock in Black and White.")
  image(awtImage: awtImage, color: null, forceBW: true)
  document.newPage()
  paragraph("Hitchcock in Red and Yellow.")
  image(awtImage: awtImage, color: new Color(0xFF, 0xFF, 0x00))
  paragraph("Hitchcock in Black and White.")
  image(awtImage: awtImage, color: new Color(0xFF, 0xFF, 0x00), forceBW: true)
}
