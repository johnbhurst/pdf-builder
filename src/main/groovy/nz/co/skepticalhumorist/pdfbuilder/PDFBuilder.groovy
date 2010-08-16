package nz.co.skepticalhumorist.pdfbuilder

class PDFBuilder extends FactoryBuilderSupport {

  OutputStream outputStream

  PDFBuilder(OutputStream outputStream) {
    this.outputStream = outputStream
    def documentFactory = new DocumentFactory()
    registerFactory("document", documentFactory)
    registerFactory("image", new ImageFactory())
    registerFactory("paragraph", new ParagraphFactory())
    registerFactory("table", new TableFactory())
    registerFactory("cell", new CellFactory())
    registerFactory("newPage", new NewPageFactory())
    registerExplicitProperty("document", {documentFactory.document}, null)
    registerExplicitProperty("writer", {documentFactory.writer}, null)
    registerExplicitMethod("page", {Closure closure -> closure.call() ; documentFactory.document.newPage() })
  }

  PDFBuilder build() {
    
  }

}
