@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.Font
import com.lowagie.text.FontFactory
import com.lowagie.text.PageSize
import com.lowagie.text.pdf.BaseFont

def rand = new Random()

def verb = [
  "flows", "draws", "renders", "throws exception",
  "runs", "crashes", "downloads", "usurps", "vexes", "whispers",
  "boils", "capitulates", "crashes", "craves", "looks", "defies",
  "defers", "defines", "envelops", "entombs", "falls", "fails",
  "halts", "appears", "nags", "overflows", "burns", "dies", "writes",
  "flushes"
]

def noun = [
  "ColumnText", "paragraph", "phrase", "chunk",
  "PdfContentByte", "PdfPTable", "iText", "color",
  "vertical alignment", "horizontal alignment", "PdfWriter",
  "ListItem", "PdfStamper", "PDF", "HTML", "XML", "column", "font",
  "table", "FDF", "field", "NullPointerException", "CJK font"
]

def adjective = [
  "foul", "broken", "gray", "slow",
  "beautiful", "throbbing", "sharp", "stout", "soundless", "neat",
  "swift", "uniform", "upright", "vibrant", "dingy", "vestigal",
  "messy", "sloppy", "baleful", "boastful", "dark", "capricious",
  "concrete", "deliberate", "sharp", "drunken", "undisciplined",
  "perfect", "bloated"
]

def adverb = [
  "randomly", "quickly", "triumphantly",
  "suggestively", "slowly", "angrily", "uncomfortably", "finally",
  "unexpectedly", "hysterically", "thinly", "dryly", "blazingly",
  "terribly", "bleakly", "irritably", "dazzlingly", "expectantly",
  "impersonally", "abruptly", "awfully", "caressingly", "completely",
  "undesirably", "drolly", "hypocritically", "blankly", "dimly"
]

def randomWord = {type ->
  type[rand.nextInt(type.size())]
}

def poemLine = {
  randomWord(adjective) + " " + randomWord(noun) + " " + randomWord(verb) + " " + randomWord(adverb) + ", "
}

def RESULT= "build/examples/in_action/chapter07/MultiColumnPoem.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4) {
  def newParagraph = {String text, int alignment, int type ->
    paragraph(string: text, font: FontFactory.getFont(BaseFont.HELVETICA, 10, type), alignment: alignment, leading: 12)
  }

  multiColumnText(init: {addRegularColumns(document.left(), document.right(), 10f, 3)}) {
    for (i in 1..30) {
      paragraph("$i")
      newParagraph(randomWord(noun), Element.ALIGN_CENTER, Font.BOLDITALIC)
      4.times {
        newParagraph(poemLine(), Element.ALIGN_LEFT, Font.NORMAL)
      }
      newParagraph(randomWord(adverb), Element.ALIGN_LEFT, Font.NORMAL)
      newParagraph("\n\n", Element.ALIGN_LEFT, Font.NORMAL)
    }
  }
}
