package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.List
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

  @Override
  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    // If called with a List, this does not match any ListItem constructor.
    // Instead we make a special case of this.
    // We return the List for List.add(List), and ignore any other attributes.
    // No ListItem is actually created.
    // Nested content is invalid.
    if (value instanceof List) {
      return value
    }
    else {
      return super.newInstance(builder, name, value, attributes)
    }
  }


}
