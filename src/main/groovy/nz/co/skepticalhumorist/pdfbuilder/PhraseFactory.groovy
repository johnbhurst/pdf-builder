package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Phrase

class PhraseFactory extends ElementFactory {

  PhraseFactory() {
    elementClass = Phrase
    ctorArgTypes = [
      [leading: float, string: String, font: Font],
      [leading: float, string: String],
      [leading: float, chunk: Chunk],
      [leading: float],
      [string: String, font: Font],
      [string: String],
      [chunk: Chunk],
      [phrase: Phrase]
    ]
  }

}
