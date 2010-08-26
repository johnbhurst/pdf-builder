package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPTable
import org.codehaus.groovy.runtime.InvokerHelper

class TableFactory extends AbstractElementFactory {

  def static ctorArgTypes = [
    [relativeWidths: float[]],
    [numColumns: int],
    [table: PdfPTable]
  ]

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    def ctorArgs = PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
    PdfPTable result = InvokerHelper.invokeConstructorOf(PdfPTable, ctorArgs)
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

}
