package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.PdfContentByte

class PdfWriterCategory {
  public static void withDirectContent(PdfWriter writer, Closure closure) {
    PdfContentByte cb = writer.getDirectContent()
    cb.saveState()
    try {
      closure.call(cb)
    }
    finally {
      cb.restoreState()
    }
  }
}
