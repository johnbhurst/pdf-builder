@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.pdf.PdfContentByte

def RESULT= "build/examples/in_action/chapter04/FoxDogRender.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  Font font = new Font(Font.COURIER, 20)
  Chunk c = new Chunk("Quick brown fox jumps over the lazy dog.", font)
  c.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL, 0f, new Color(0xFF, 0x00, 0x00))
  paragraph(c)
  c.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE, 0.3f, new Color(0xFF, 0x00, 0x00))
  paragraph(c)
  c.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_INVISIBLE, 0f, new Color(0x00, 0xFF, 0x00))
  paragraph(c)
  c.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_STROKE, 0.3f, new Color(0x00, 0x00, 0xFF))
  paragraph(c)
  chunk(Chunk.NEWLINE)
  chunk("This looks like Font.BOLD", init: {it.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE, 0.5f, null)})
}
