@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Document
import com.lowagie.text.Font
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.PdfWriter

def SPEAKER_FONT = new Font(Font.HELVETICA, 12, Font.BOLD)
def lines = [:].withDefault {0}
new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter04/FoxDogGeneric2.pdf")).document(
    onGenericTag: {PdfWriter writer, Document document, Rectangle rect, String text ->
      lines[text] += 1
    }
  ) {
  def line = {String speaker, String line ->
    paragraph(leading: 18) {
      chunk(content: "${speaker}: ", font: SPEAKER_FONT ,genericTag: speaker)
      chunk(line)
    }
  }
  line("Fox", "Hello lazy dog.")
  line("Dog", "Hello quick brown fox.")
  line("Fox", "I want to jump over you.")
  line("Dog", "No problem. Go ahead!")
  line("Narrator", "And the fox jumps over the dog.")
  line("Fox", "Thank you very much, lazy dog.")
  line("Dog", "You're welcome.")
  line("Fox", "See you.")
  line("Dog", "Bye!")
  line("Narrator", "The fox leaves the dog.")
  document.newPage()
  lines.each {speaker, count ->
    paragraph("$speaker: $count lines.")
  }
}
