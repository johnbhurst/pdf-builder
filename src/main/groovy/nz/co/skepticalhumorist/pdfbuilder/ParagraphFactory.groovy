package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase

class ParagraphFactory extends ElementFactory {

  ParagraphFactory() {
    elementClass = Paragraph
    ctorArgTypes = [
      [leading: float, string: String, font: Font],
      [leading: float, chunk: Chunk],
      [leading: float, string: String],
      [string: String, font: Font],
      [leading: float],
      [string: String],
      [chunk: Chunk],
      [phrase: Phrase]
    ]
  }

}
