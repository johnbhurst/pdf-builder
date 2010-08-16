package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.pdf.PdfContentByte

class PdfCategory {
  static void withDirectContent(PdfWriter writer, Closure closure) {
    doWithContentByte(writer.directContent, closure)
  }

  static void withDirectContentUnder(PdfWriter writer, Closure closure) {
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

  // tentative ... either this or perhaps withDirectContentWithText() ?
  static void withText(PdfContentByte cb, Closure closure) {
    cb.beginText()
    try {
      closure.call(cb)
    }
    finally {
      cb.endText()
    }
  }
}
