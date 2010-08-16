@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.BaseFont

def RESULT = "build/examples/classroom/intro/hello05.pdf"
BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
new PDFBuilder(new FileOutputStream(RESULT)).document(
  // This example uses the onOpenDocument event hook to write with the DirectContent layer.
  // It would be better if this layer could be accessed via the main builder block.
  // I.e., it would be more analogous to the iText example.
  // But on the other hand, accessing DirectContent via event hooks might be a more typically real use-case.
  onOpenDocument: {writer, document ->
    writer.withDirectContent {PdfContentByte cb ->
      cb.beginText() // BT
      cb.moveText(36, 806) // 36 806 Td
      cb.moveText(0, -18) // 0 -18 Td
      cb.setFontAndSize(bf, 12) // /F1 12 Tf
      cb.showText("Hello World") // (Hello World)Tj
      cb.endText() // ET
    }
  }
) {
  // nothing in main
}
