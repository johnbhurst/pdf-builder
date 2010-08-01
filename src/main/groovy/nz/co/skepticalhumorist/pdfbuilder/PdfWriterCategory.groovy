package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.PdfContentByte

class PdfWriterCategory {
  public static void withDirectContent(PdfWriter writer, Closure closure) {
    doWithContentByte(writer.directContent, closure)
  }

  public static void withDirectContentUnder(PdfWriter writer, Closure closure) {
    doWithContentByte(writer.directContentUnder, closure)
  }

  private static void doWithContentByte(PdfContentByte cb, Closure closure) {
    cb.saveState()
    try {
      closure.call(cb)
    }
    finally {
      cb.restoreState()
    }
  }
}
