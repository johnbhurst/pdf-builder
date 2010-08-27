package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ListItem
import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Phrase

class ListItemFactory extends ElementFactory {

  ListItemFactory() {
    elementClass = ListItem
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
