package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Anchor
import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Phrase

class AnchorFactory extends ElementFactory {

  AnchorFactory() {
    elementClass = Anchor
    ctorArgTypes = [
      [leading: float, string: String, font: Font],
      [leading: float, string: String],
      [leading: float, chunk: Chunk],
      [string: String, font: Font],
      [leading: float],
      [chunk: Chunk],
      [string: String],
      [phrase: Phrase]
    ]
  }
  
}
