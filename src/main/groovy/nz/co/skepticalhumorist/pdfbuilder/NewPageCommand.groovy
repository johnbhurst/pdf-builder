package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.Document

class NewPageCommand implements DocumentCommand {
  void applyTo(Document document) {
    document.newPage()
  }
}
