package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Document

public interface DocumentCommand {

  void applyTo(Document document)

}