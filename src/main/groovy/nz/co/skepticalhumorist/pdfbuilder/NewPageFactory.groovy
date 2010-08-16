package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Document

class NewPageFactory extends AbstractFactory {

  DocumentCommand newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    return {Document document -> document.newPage()} as DocumentCommand
  }

}
