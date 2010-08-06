package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPCell

class CellFactory extends AbstractFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    return new PdfPCell(value)
  }

}
