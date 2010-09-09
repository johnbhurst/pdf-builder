@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.Element
import com.lowagie.text.Font

// This version uses a different sequence of API calls from the original example.
// This version creates a new Paragraph each time rather than reusing the same one.
// This is more representative of the style of use the builder is intended for.
def RESULT= "build/examples/in_action/chapter04/FoxDogParagraph2.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  String text = "Quick brown fox jumps over the lazy dog."
  def chunks = {
    phrase(text)
    chunk(" ")
    phrase(new Chunk(text, new Font(Font.TIMES_ROMAN)))
    chunk(" ")
    phrase(string: text, font: new Font(Font.COURIER))
  }

  paragraph {chunks()}
  paragraph {chunks()}
  paragraph(alignment: Element.ALIGN_LEFT) {chunks()}
  paragraph(alignment: Element.ALIGN_CENTER) {chunks()}
  paragraph(alignment: Element.ALIGN_RIGHT) {chunks()}
  paragraph(alignment: Element.ALIGN_JUSTIFIED) {chunks()}
  paragraph(alignment: Element.ALIGN_JUSTIFIED, spacingBefore: 10) {chunks()}
  paragraph(alignment: Element.ALIGN_JUSTIFIED, spacingAfter: 10) {chunks()}
  paragraph(alignment: Element.ALIGN_JUSTIFIED, spacingAfter: 10, indentationLeft: 20) {chunks()}
  paragraph(alignment: Element.ALIGN_JUSTIFIED, spacingAfter: 10, indentationLeft: 20, indentationRight: 20) {chunks()}
}
