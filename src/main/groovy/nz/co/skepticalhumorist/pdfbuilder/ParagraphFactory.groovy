package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.Paragraph

class ParagraphFactory extends AbstractFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    if (attributes.containsKey("string")) {
      String string = attributes.remove("string")
      return new Paragraph(string)
    }
    return null
  }

}
