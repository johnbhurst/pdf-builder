package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.pdf.PdfContentByte

class PdfCategory {
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
