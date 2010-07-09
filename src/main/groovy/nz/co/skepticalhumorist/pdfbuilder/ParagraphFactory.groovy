package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.Font
import com.itextpdf.text.Paragraph

class ParagraphFactory extends AbstractFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    String string = attributes.containsKey("string") ? attributes.remove("string") : value
    if (attributes.containsKey("font")) {
      Font font = attributes.remove("font")
      return new Paragraph(string, font)
    }
    return new Paragraph(string)
  }

}
