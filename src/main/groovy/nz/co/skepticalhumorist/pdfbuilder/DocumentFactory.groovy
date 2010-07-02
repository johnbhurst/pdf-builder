package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.Document

class DocumentFactory extends AbstractFactory {

  PDFBuilder builder
  Document document

  DocumentFactory(builder) {
    this.builder = builder;
  }

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    document = new Document()
    return document
  }
}

