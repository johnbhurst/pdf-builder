package nz.co.skepticalhumorist.pdfbuilder

class PDFBuilder extends FactoryBuilderSupport {

  OutputStream outputStream

  PDFBuilder(OutputStream outputStream) {
    this.outputStream = outputStream
    def documentFactory = new DocumentFactory()
    registerFactory("document", documentFactory)

    registerFactory("anchor", new AnchorFactory())
//    registerFactory("annotation", new AnnotationFactory())
    registerFactory("cell", new CellFactory())
//    registerFactory("chapter", new ChapterFactory())
//    registerFactory("chapterAutoNumber", new ChapterAutoNumberFactory())
    registerFactory("chunk", new ChunkFactory())
//    registerFactory("dottedLineSeparator", new DottedLineSeparatorFactory())
//    registerFactory("greekList", new GreekListFactory())
//    registerFactory("header", new HeaderFactory())
    registerFactory("image", new ImageFactory())
//    registerFactory("imgCCITT", new ImgCCITTFactory())
//    registerFactory("imgJBig", new ImgJBigFactory())
//    registerFactory("imgRaw", new ImgRawFactory())
//    registerFactory("imgTemplate", new ImgTemplateFactory())
//    registerFactory("imgWMF", new ImgWMFactory())
//    registerFactory("incCell", new IncCellFactory())
//    registerFactory("jpeg", new JpegFactory())
//    registerFactory("jpeg2000", new Jpeg2000Factory())
//    registerFactory("lineSeparator", new LineSeparatorFactory())
//    registerFactory("list", new ListFactory())
//    registerFactory("listItem", new ListItemFactory())
//    registerFactory("markedObject", new MarkedObjectFactory())
//    registerFactory("markedSection", new MarkedSectionFactory())
//    registerFactory("meta", new MetaFactory())
//    registerFactory("multiColumnText", new MultiColumnTextFactory())
    registerFactory("paragraph", new ParagraphFactory())
//    registerFactory("phrase", new PhraseFactory())
//    registerFactory("rectangle", new RectangleFactory())
//    registerFactory("rectangleReadOnly", new RectangleReadOnlyFactory())
//    registerFactory("romanList", new RomanListFactory())
//    registerFactory("section", new SectionFactory())
    registerFactory("table", new TableFactory())
//    registerFactory("verticalPositionMark", new VerticalPositionMarkFactory())
//    registerFactory("zapfDigbatsList", new ZapfDigbatsListFactory())
//    registerFactory("zapfDigbatsNumberList", new ZapfDigbatsNumberListFactory())

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
