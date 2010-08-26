package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable

abstract class AbstractElementFactory extends AbstractFactory {

  def constructFromAttributes(Class cls, List<Map<String, Class>> constructors, Map<String, Object> attributes, Object value) {
    constructors.each {ctorMap ->
      def ctorAttrNames = ctorMap.keySet()
      if (ctorAttrNames.every {k -> attributes.containsKey(k)}) {
        def args = ctorAttrNames.collect {k -> attributes.remove(k)}
        return cls.newInstance(*args)
      }
    }
    if (value && value instanceof GString) {
      // why do we need to treat this specially?
      return cls.newInstance(value.toString())
    }
    else if (value) {
      return cls.newInstance(value)
    }
    else {
      return cls.newInstance()
    }
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
