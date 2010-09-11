@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.pdf.PdfContentByte

def RESULT= "build/examples/in_action/chapter04/FoxDogUnderline.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  def initChunkUnderline = {Chunk c ->
    c.setUnderline(new Color(0x00, 0x00, 0xFF), 0.0f, 0.2f, 15.0f, 0.0f, PdfContentByte.LINE_CAP_BUTT)
    c.setUnderline(new Color(0x00, 0xFF, 0x00), 5.0f, 0.0f, 0.0f, -0.5f, PdfContentByte.LINE_CAP_PROJECTING_SQUARE)
    c.setUnderline(new Color(0xFF, 0x00, 0x00), 0.0f, 0.3f, 0.0f, 0.4f, PdfContentByte.LINE_CAP_ROUND)
  }
  paragraph(new Chunk("")) { // initializing the paragraph thus seems to have some magical effect on the line spacing of the rest of the document.
    chunk("Quick brown fox", init: {c -> c.setUnderline(0.2, -2)})
    chunk(" ")
    chunk("jumps over", init: {c -> c.setUnderline(0.5, 3)})
    chunk(" ")
    chunk("the lazy dog.", init: {c -> c.setUnderline(0.2, 14)})
  }
  3.times {chunk(Chunk.NEWLINE)}
  chunk("Quick brown fox jumps over the lazy dog.", init: initChunkUnderline)
  3.times {chunk(Chunk.NEWLINE)}
  chunk(content: "Quick brown fox jumps over the lazy dog.", font: new Font(Font.HELVETICA, 24), init: initChunkUnderline)
}
