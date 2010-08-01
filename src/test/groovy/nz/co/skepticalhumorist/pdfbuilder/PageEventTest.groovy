package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test

class PageEventTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    File file = new File(tmpDir, "PageEventTest.pdf")
    new PDFBuilder(outputStream: file.newOutputStream()).document(
      onChapter: {writer, document, paragraphPosition, title ->
        println("onChapter($writer, $document, $paragraphPosition, $title)")
      },
      onChapterEnd: {writer, document, paragraphPosition ->
        println("onChapterEnd($writer, $document, $paragraphPosition)")
      },
      onCloseDocument: {writer, document ->
        println("onCloseDocument($writer, $document)")
      },
      onEndPage: {writer, document ->
        println("onEndPage($writer, $document)")
      },
      onGenericTag: {writer, document, rect, text ->
        println("onGenericTag($writer, $document, $rect, $text)")
      },
      onOpenDocument: {writer, document ->
        println("onOpenDocument($writer, $document)")
      },
      onParagraph: {writer, document, paragraphPosition ->
        println("onParagraph($writer, $document, $paragraphPosition)")
      },
      onParagraphEnd: {writer, document, paragraphPosition ->
        println("onParagraphEnd($writer, $document, $paragraphPosition)")
      },
      onSection: {writer, document, paragraphPosition, depth, title ->
        println("onSection($writer, $document, $paragraphPosition, $depth, $title)")
      },
      onSectionEnd: {writer, document, paragraphPosition ->
        println("onSectionEnd($writer, $document, $paragraphPosition)")
      },
      onStartPage: {writer, document ->
        println("onStartPage($writer, $document)")
      }
    ) {
      paragraph("A very short document, with many events.")
    }
  }

}
