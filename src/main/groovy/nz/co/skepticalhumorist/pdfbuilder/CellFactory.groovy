package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPCell

class CellFactory extends AbstractElementFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    return new PdfPCell(value)
  }

}
