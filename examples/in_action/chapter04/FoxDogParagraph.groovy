@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.Element
import com.lowagie.text.Font
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase

// This version uses the same sequence of API calls as the original iText example.
// It does not show good usage of the builder's API, because the paragraph is
// created and used many times.
// This is not representative of use cases the builder is intended for.
def RESULT= "build/examples/in_action/chapter04/FoxDogParagraph.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  Chunk space = new Chunk(' ')
  String text = "Quick brown fox jumps over the lazy dog."
  Phrase phrase1 = new Phrase(text)
  Phrase phrase2 = new Phrase(new Chunk(text, new Font(Font.TIMES_ROMAN)))
  Phrase phrase3 = new Phrase(text, new Font(Font.COURIER))
  Paragraph paragraph = new Paragraph()
  paragraph.add(phrase1)
  paragraph.add(space)
  paragraph.add(phrase2)
  paragraph.add(space)
  paragraph.add(phrase3)
  document.add(paragraph)
  document.add(paragraph)
  paragraph.alignment = Element.ALIGN_LEFT
  document.add(paragraph)
  paragraph.alignment = Element.ALIGN_CENTER
  document.add(paragraph)
  paragraph.alignment = Element.ALIGN_RIGHT
  document.add(paragraph)
  paragraph.alignment = Element.ALIGN_JUSTIFIED
  document.add(paragraph)
  paragraph.spacingBefore = 10
  document.add(paragraph)
  paragraph.spacingBefore = 0
  paragraph.spacingAfter = 10
  document.add(paragraph)
  paragraph.indentationLeft = 20
  document.add(paragraph)
  paragraph.indentationRight = 20
  document.add(paragraph)
}
