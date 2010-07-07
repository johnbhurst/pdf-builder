package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.Paragraph

class CellFactory extends AbstractFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    if (attributes.containsKey("string")) {
      String string = attributes.remove("string")
      return new PdfPCell(new Paragraph(string))
    }
    return null
  }

}
