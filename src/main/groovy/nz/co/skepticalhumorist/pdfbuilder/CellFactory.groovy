package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.Image
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.PdfPTable
import org.codehaus.groovy.runtime.InvokerHelper

class CellFactory extends AbstractElementFactory {

  def static ctorArgTypes = [
    [phrase: Phrase],
    [image: Image, fit: boolean],
    [image: Image],
    [table: PdfPTable, style: PdfPCell],
    [table: PdfPTable],
    [cell: PdfPCell]
  ]

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    def ctorArgs = PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
    PdfPCell result = InvokerHelper.invokeConstructorOf(PdfPCell, ctorArgs)
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

}
