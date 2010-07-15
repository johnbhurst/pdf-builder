package nz.co.skepticalhumorist.pdfbuilder

class PDFBuilder extends FactoryBuilderSupport {

  OutputStream outputStream

  PDFBuilder() {
    registerFactory("document", new DocumentFactory(this))
    registerFactory("image", new ImageFactory())
    registerFactory("paragraph", new ParagraphFactory())
    registerFactory("table", new TableFactory())
    registerFactory("cell", new CellFactory())
    registerFactory("newPage", new NewPageFactory())
  }

  PDFBuilder build() {
    
  }

}
