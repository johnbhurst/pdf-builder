@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.SplitCharacter
import com.lowagie.text.pdf.PdfChunk

class FoxDogSplitCharacter implements SplitCharacter {
  boolean isSplitCharacter(int start, int current, int end, char[] cc, PdfChunk[] ck) {
    char c = ck == null ?
      cc[current] :
      (char) ck[Math.min(current, ck.length - 1)].getUnicodeEquivalent(cc[current])
    return c == '/' || c == ' '
  }
}

def RESULT= "build/examples/in_action/chapter04/FoxDogSplit.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  String text = "This is the link that explains the sentence 'Quick brown fox jumps over the lazy dog: "
  String url = "http://en.wikipedia.org/wiki/The_quick_brown_fox_jumps_over_the_lazy_dog"
  Font font = new Font(Font.HELVETICA, 18)
  paragraph("Default split behavior.")
  paragraph(leading: 24, chunk: new Chunk(text, font)) {
    chunk(content: url, font: font)
  }
  chunk(Chunk.NEWLINE)
  paragraph("Space and forward slash are split characters.")
  paragraph(leading: 24, chunk: new Chunk(text, font)) {
    chunk(content: url, font: font, splitCharacter: new FoxDogSplitCharacter())
  }
}
