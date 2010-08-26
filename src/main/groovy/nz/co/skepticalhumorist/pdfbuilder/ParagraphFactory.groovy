package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase
import org.codehaus.groovy.runtime.InvokerHelper

class ParagraphFactory extends AbstractElementFactory {

  def static ctorArgTypes = [
    [leading: float, string: String, font: Font],
    [leading: float, chunk: Chunk],
    [leading: float, string: String],
    [string: String, font: Font],
    [leading: float],
    [string: String],
    [chunk: Chunk],
    [phrase: Phrase]
  ]

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    def ctorArgs = PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
    Paragraph result = InvokerHelper.invokeConstructorOf(Paragraph, ctorArgs) 
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

}
