package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.pdf.PdfPageEvent
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.Rectangle

class ClosurePdfPageEvent implements PdfPageEvent {

  Closure onOpenDocument = {}
  Closure onStartPage = {}
  Closure onEndPage = {}
  Closure onCloseDocument = {}
  Closure onParagraph = {}
  Closure onParagraphEnd = {}
  Closure onChapter = {}
  Closure onChapterEnd = {}
  Closure onSection = {}
  Closure onSectionEnd = {}
  Closure onGenericTag = {}

  void onOpenDocument(PdfWriter writer, Document document) {
    onOpenDocument.call(writer, document)
  }

  void onStartPage(PdfWriter writer, Document document) {
    onStartPage.call(writer, document)
  }

  void onEndPage(PdfWriter writer, Document document) {
    onEndPage.call(writer, document)
  }

  void onCloseDocument(PdfWriter writer, Document document) {
    onCloseDocument.call(writer, document)
  }

  void onParagraph(PdfWriter writer, Document document, float paragraphPosition) {
    onParagraph.call(writer,  document, paragraphPosition)
  }

  void onParagraphEnd(PdfWriter writer, Document document, float paragraphPosition) {
    onParagraphEnd.call(writer, document, paragraphPosition)
  }

  void onChapter(PdfWriter writer, Document document, float paragraphPosition, Paragraph title) {
    onChapter.call(writer, document, paragraphPosition, title)
  }

  void onChapterEnd(PdfWriter writer, Document document, float paragraphPosition) {
    onChapterEnd.call(writer, document, paragraphPosition)
  }

  void onSection(PdfWriter writer, Document document, float paragraphPosition, int depth, Paragraph title) {
    onSection.call(writer, document, paragraphPosition, depth, title)
  }

  void onSectionEnd(PdfWriter writer, Document document, float paragraphPosition) {
    onSectionEnd.call(writer, document, paragraphPosition)
  }

  void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
    onGenericTag.call(writer, document, rect, text)
  }

}
