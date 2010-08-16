@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.BaseFont

def RESULT = "build/examples/classroom/intro/hello05a.pdf"
BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  writer.withDirectContent {PdfContentByte cb ->
    // This version shows the withText category method,
    // which handles the beginText()/endText() calls on the PdfContentByte.
    // However, this use of a closure within a closure is a bit awkward.
    // Should we have withDirectContentText() (etc) instead?
    cb.withText {
      cb.moveText(36, 806) // 36 806 Td
      cb.moveText(0, -18) // 0 -18 Td
      cb.setFontAndSize(bf, 12) // /F1 12 Tf
      cb.showText("Hello World") // (Hello World)Tj
    }
  }
}
