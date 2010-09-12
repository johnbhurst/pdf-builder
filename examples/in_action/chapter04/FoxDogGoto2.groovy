@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Font
import com.lowagie.text.FontFactory

Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE, new Color(0, 0, 255))

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter04/FoxDogGoto2Fox.pdf")).document() {
  paragraph("The quick brown fox wants to") {
    chunk(content: " jump over ", font: font, init: {it.setRemoteGoto("FoxDogGoto2Dog.pdf", "jump")})
    chunk(" the lazy dog.")
  }
  7.times {paragraph("blah, blah, blah")}
  document.newPage()
  paragraph("Page 2")
  document.newPage()
  paragraph("Page 3")
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter04/FoxDogGoto2Dog.pdf")).document() {
  7.times {paragraph("blah, blah, blah")}
  paragraph("The quick brown fox has jumped over ") {
    chunk(content: "the lazy dog.", font: font, localDestination: "jump")
  }
  paragraph("you can also jump to a ") {
    chunk(content: "specific page on another document", font: font, init: {it.setRemoteGoto("FoxDogGoto2Fox.pdf", 3)})
  }
}
