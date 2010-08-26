package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable

abstract class AbstractElementFactory extends AbstractFactory {

  def argsFromAttributes(List<Map<String, Class>> argTypes, Map<String, Object> attributes, Object value) {
    for (argTypeMap in argTypes) {
      def argNames = argTypeMap.keySet()
      if (attributes.keySet().containsAll(argNames)) {
        return argNames.collect {argName -> attributes.remove(argName)}.toArray()
      }
    }
    return value
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
