@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.Element

def RESULT = "build/examples/classroom/intro/hello07.pdf"
BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
new PDFBuilder(new FileOutputStream(RESULT)).document(
  // This example uses the onOpenDocument event hook to write with the DirectContent layer.
  // It would be better if this layer could be accessed via the main builder block.
  // I.e., it would be more analogous to the iText example.
  // But on the other hand, accessing DirectContent via event hooks might be a more typically real use-case.
  onOpenDocument: {writer, document ->
    writer.directContent.with {cb ->
      cb.beginText()
      cb.setFontAndSize(bf, 12)
      cb.showTextAligned(Element.ALIGN_LEFT, "Hello World", 36, 788, 0)
      cb.endText()
    }
  }
) {
  // nothing in main
}
