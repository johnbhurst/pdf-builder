@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Font
import com.lowagie.text.pdf.PdfContentByte

def RESULT= "build/examples/in_action/chapter04/FoxDogChunk2.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  Font font = new Font(Font.COURIER, 10, Font.BOLD)
  font.color = new Color(0xFF, 0xFF, 0xFF)
  Color background = new Color(0xa5, 0x2a, 0x2a)
  float superscript = 8.0f
  float subscript = -8.0f
  10.times {
    chunk(content: "Quick brown fox", font: font, textRise: superscript, background: background)
    chunk(content: " jumps over ", font: new Font())
    chunk(content: "the lazy dog.", font: new Font(Font.TIMES_ROMAN, 14, Font.ITALIC), textRise: subscript) {
      current.setUnderline(new Color(0xFF, 0x00, 0x00), 3.0f, 0.0f, -5.0f + subscript as float, 0.0f, PdfContentByte.LINE_CAP_ROUND)
    }
    chunk(" ")
  }
}
