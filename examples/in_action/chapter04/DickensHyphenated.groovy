@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.PageSize
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.HyphenationAuto

def RESULT= "build/examples/in_action/chapter04/DickensHyphenated.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A6, marginMirroring: true) {
  String text = "It was the best of times, it was the worst of times, " +
    "it was the age of wisdom, it was the age of foolishness, " +
    "it was the epoch of belief, it was the epoch of incredulity, " +
    "it was the season of Light, it was the season of Darkness, " +
    "it was the spring of hope, it was the winter of despair, " +
    "we had everything before us, we had nothing before us, " +
    "we were all going direct to Heaven, we were all going direct " +
    "the other way\u2014in short, the period was so far like the present " +
    "period, that some of its noisiest authorities insisted on its " +
    "being received, for good or for evil, in the superlative degree " +
    "of comparison only.";
  paragraph("", alignment: Paragraph.ALIGN_JUSTIFIED) {
    chunk(text, hyphenation: new HyphenationAuto("en", "GB", 2, 2))
  }
// This also works:
//  Chunk chunk = new Chunk(text)
//  chunk.hyphenation = new HyphenationAuto("en", "GB", 2, 2)
//  paragraph(chunk, alignment: Paragraph.ALIGN_JUSTIFIED)
}
