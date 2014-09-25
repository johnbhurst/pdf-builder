// Copyright 2014- John Hurst
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package nz.co.skepticalhumorist.pdfbuilder

class PDFBuilder extends FactoryBuilderSupport {

  OutputStream outputStream

  PDFBuilder(OutputStream outputStream) {
    this.outputStream = outputStream
    def documentFactory = new DocumentFactory()
    registerFactory("document", documentFactory)

    registerFactory("anchor", new AnchorFactory())
    registerFactory("annotation", new AnnotationFactory())
    registerFactory("cell", new CellFactory())
    registerFactory("chapter", new ChapterFactory())
    registerFactory("chapterAutoNumber", new ChapterAutoNumberFactory())
    registerFactory("chunk", new ChunkFactory())
    registerFactory("dottedLineSeparator", new DottedLineSeparatorFactory())
    registerFactory("greekList", new GreekListFactory())
    registerFactory("header", new HeaderFactory())
    registerFactory("image", new ImageFactory())
    registerFactory("imgCCITT", new ImgCCITTFactory())
    registerFactory("imgJBIG2", new ImgJBIG2Factory())
    registerFactory("imgRaw", new ImgRawFactory())
    registerFactory("imgTemplate", new ImgTemplateFactory())
    registerFactory("imgWMF", new ImgWMFFactory())
//    registerFactory("incCell", new IncCellFactory())
    registerFactory("jpeg", new JpegFactory())
    registerFactory("jpeg2000", new Jpeg2000Factory())
    registerFactory("lineSeparator", new LineSeparatorFactory())
    registerFactory("list", new ListFactory())
    registerFactory("listItem", new ListItemFactory())
//    registerFactory("markedObject", new MarkedObjectFactory())
//    registerFactory("markedSection", new MarkedSectionFactory())
    registerFactory("meta", new MetaFactory())
    registerFactory("multiColumnText", new MultiColumnTextFactory())
    registerFactory("paragraph", new ParagraphFactory())
    registerFactory("phrase", new PhraseFactory())
    registerFactory("rectangle", new RectangleFactory())
    registerFactory("rectangleReadOnly", new RectangleReadOnlyFactory())
    registerFactory("romanList", new RomanListFactory())
    registerFactory("section", new SectionFactory())
    registerFactory("table", new TableFactory())
    registerFactory("verticalPositionMark", new VerticalPositionMarkFactory())
    registerFactory("zapfDingbatsList", new ZapfDingbatsListFactory())
    registerFactory("zapfDingbatsNumberList", new ZapfDingbatsNumberListFactory())

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

}
