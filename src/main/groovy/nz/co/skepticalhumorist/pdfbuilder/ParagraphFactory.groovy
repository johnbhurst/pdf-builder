package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Font
import com.lowagie.text.Paragraph
import com.lowagie.text.Chunk
import com.lowagie.text.Phrase

class ParagraphFactory extends AbstractElementFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    Paragraph result = null
    if (attributes.containsKey("leading") && attributes.containsKey("string") && attributes.containsKey("font")) {
      float leading = attributes.remove("leading")
      String string = attributes.remove("string")
      Font font = attributes.remove("font")
      result = new Paragraph(leading, string, font)
    }
    else if (attributes.containsKey("leading") && attributes.containsKey("chunk")) {
      float leading = attributes.remove("leading")
      Chunk chunk = attributes.remove("chunk")
      result = new Paragraph(leading, chunk)
    }
    else if (attributes.containsKey("leading") && attributes.containsKey("string")) {
      float leading = attributes.remove("leading")
      String string = attributes.remove("string")
      result = new Paragraph(leading, string)
    }
    else if (attributes.containsKey("string") && attributes.containsKey("font")) {
      String string = attributes.remove("string")
      Font font = attributes.remove("font")
      result = new Paragraph(string, font)
    }
    else if (attributes.containsKey("leading")) {
      float leading = attributes.remove("leading")
      result = new Paragraph(leading)
    }
    else if (attributes.containsKey("string")) {
      String string = attributes.remove("string")
      result = new Paragraph(string)
    }
    else if (attributes.containsKey("chunk")) {
      Chunk chunk = attributes.remove("chunk")
      result = new Paragraph(chunk)
    }
    else if (attributes.containsKey("phrase")) {
      Phrase phrase = attributes.remove("phrase")
      result = new Paragraph(phrase)
    }
    else {
      result = new Paragraph(value)
    }
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

}
