package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfPageEvent
import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.Document
import com.lowagie.text.Paragraph
import com.lowagie.text.Rectangle
import org.codehaus.groovy.runtime.DefaultGroovyMethods

class ClosurePdfPageEvent implements PdfPageEvent {

  Closure onOpenDocument
  Closure onStartPage
  Closure onEndPage
  Closure onCloseDocument
  Closure onParagraph
  Closure onParagraphEnd
  Closure onChapter
  Closure onChapterEnd
  Closure onSection
  Closure onSectionEnd
  Closure onGenericTag

  void onOpenDocument(PdfWriter writer, Document document) {
    DefaultGroovyMethods.mixin(writer.directContent.metaClass, PdfCategory)
    DefaultGroovyMethods.mixin(writer.directContentUnder.metaClass, PdfCategory)
    if (onOpenDocument) {
      onOpenDocument.call(writer, document)
    }
  }

  void onStartPage(PdfWriter writer, Document document) {
    if (onStartPage) {
      onStartPage.call(writer, document)
    }
  }

  void onEndPage(PdfWriter writer, Document document) {
    if (onEndPage) {
      onEndPage.call(writer, document)
    }
  }

  void onCloseDocument(PdfWriter writer, Document document) {
    if (onCloseDocument) {
      onCloseDocument.call(writer, document)
    }
  }

  void onParagraph(PdfWriter writer, Document document, float paragraphPosition) {
    if (onParagraph) {
      onParagraph.call(writer,  document, paragraphPosition)
    }
  }

  void onParagraphEnd(PdfWriter writer, Document document, float paragraphPosition) {
    if (onParagraphEnd) {
      onParagraphEnd.call(writer, document, paragraphPosition)
    }
  }

  void onChapter(PdfWriter writer, Document document, float paragraphPosition, Paragraph title) {
    if (onChapter) {
      onChapter.call(writer, document, paragraphPosition, title)
    }
  }

  void onChapterEnd(PdfWriter writer, Document document, float paragraphPosition) {
    if (onChapterEnd) {
      onChapterEnd.call(writer, document, paragraphPosition)
    }
  }

  void onSection(PdfWriter writer, Document document, float paragraphPosition, int depth, Paragraph title) {
    if (onSection) {
      onSection.call(writer, document, paragraphPosition, depth, title)
    }
  }

  void onSectionEnd(PdfWriter writer, Document document, float paragraphPosition) {
    if (onSectionEnd) {
      onSectionEnd.call(writer, document, paragraphPosition)
    }
  }

  void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
    if (onGenericTag) {
      onGenericTag.call(writer, document, rect, text)
    }
  }

}
