@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Document
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.PdfWriter

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter04/FoxDogGeneric1.pdf")).document(
  onGenericTag: {PdfWriter writer, Document document, Rectangle rect, String text ->
    if ("ellipse".equals(text)) {
      writer.directContent.with {
        setRGBColorStroke(0xFF, 0x00, 0x00)
        ellipse(rect.left, rect.bottom - 5 as float, rect.right, rect.top)
        stroke()
        resetRGBColorStroke()
      }
    }
    else if ("box".equals(text)) {
      rect.backgroundColor = new Color(0xa5, 0x2a, 0x2a)
      writer.directContentUnder.rectangle(rect)
    }
  }) {
  paragraph() {
    chunk("Quick brown fox", genericTag: "box")
    chunk(" jumps over ")
    chunk("the lazy dog.", genericTag: "ellipse")
  }
}
