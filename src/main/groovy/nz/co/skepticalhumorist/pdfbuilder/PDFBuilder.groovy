package nz.co.skepticalhumorist.pdfbuilder

class PDFBuilder extends FactoryBuilderSupport {

  OutputStream outputStream

  PDFBuilder(OutputStream outputStream) {
    this.outputStream = outputStream
    def documentFactory = new DocumentFactory()
    registerFactory("document", documentFactory)

    registerFactory("anchor", new AnchorFactory())
    registerFactory("cell", new CellFactory())
    registerFactory("chunk", new ChunkFactory())
    registerFactory("image", new ImageFactory())
    registerFactory("paragraph", new ParagraphFactory())
    registerFactory("table", new TableFactory())

    registerExplicitProperty("document", {documentFactory.document}, null)
    registerExplicitProperty("writer", {documentFactory.writer}, null)
  }

  def static argsFromAttributes(List<Map<String, Class>> argTypes, Map<String, Object> attributes, Object value) {
    for (argTypeMap in argTypes) {
      def argNames = argTypeMap.keySet()
      if (attributes.keySet().containsAll(argNames)) {
        return argNames.collect {argName -> attributes.remove(argName)}.toArray()
      }
    }
    return value
  }

  PDFBuilder build() {
    
  }

}
