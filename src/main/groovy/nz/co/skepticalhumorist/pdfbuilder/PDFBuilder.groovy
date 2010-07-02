package nz.co.skepticalhumorist.pdfbuilder

class PDFBuilder extends FactoryBuilderSupport {

  OutputStream outputStream

  PDFBuilder() {
    registerFactory("document", new DocumentFactory(this))
  }

}
