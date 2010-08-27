package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import org.codehaus.groovy.runtime.InvokerHelper

class ElementFactory extends AbstractFactory {

  Class elementClass
  List ctorArgTypes

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    def ctorArgs = getArgs(attributes, value)
    def result = createInstance(ctorArgs)
    if (attributes.containsKey("init")) {
      Closure init = attributes.remove("init")
      init.delegate = result
      init()
    }
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

  def createInstance(ctorArgs) {
    return InvokerHelper.invokeConstructorOf(elementClass, ctorArgs)
  }

  def getArgs(Map attributes, value) {
    return PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
  }

  @Override
  void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    switch (parent) {
      case PdfPCell: parent.addElement(node); break;
      case PdfPTable: parent.addCell(node); break;
      default: parent.add(node)
    }
  }

}
