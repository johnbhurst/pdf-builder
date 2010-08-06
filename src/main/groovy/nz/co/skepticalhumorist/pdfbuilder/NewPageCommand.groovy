package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Document

class NewPageCommand implements DocumentCommand {
  void applyTo(Document document) {
    document.newPage()
  }
}
