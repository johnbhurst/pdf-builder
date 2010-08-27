package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Image
import com.lowagie.text.pdf.draw.DrawInterface

class ChunkFactory extends ElementFactory {

  ChunkFactory() {
    elementClass = Chunk
    ctorArgTypes = [
      [chunk: Chunk],
      [content: String, font: Font],
      [content: String],
      [c: char, font: Font],
      [c: char],
      [image: Image, offsetX: float, offsetY: float, changeLeading: boolean],
      [image: Image, offsetX: float, offsetY: float],
      [separator: DrawInterface, tabPosition: float, newline: boolean],
      [separator: DrawInterface, tabPosition: float],
      [separator: DrawInterface, vertical: boolean],
      [separator: DrawInterface],
    ]
  }

}
