package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Image
import com.lowagie.text.pdf.draw.DrawInterface
import org.codehaus.groovy.runtime.InvokerHelper

class ChunkFactory extends AbstractElementFactory {

  def static ctorArgTypes = [
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

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    def ctorArgs = PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
    Chunk result = InvokerHelper.invokeConstructorOf(Chunk, ctorArgs)
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

}
