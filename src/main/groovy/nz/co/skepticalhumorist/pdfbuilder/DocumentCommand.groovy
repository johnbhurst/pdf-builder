package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.Document

public interface DocumentCommand {

  void applyTo(Document document)

}