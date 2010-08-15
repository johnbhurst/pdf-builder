@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.pdf.PdfTemplate

def RESULT = "build/examples/classroom/intro/hello08.pdf"
BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
new PDFBuilder(new FileOutputStream(RESULT)).document(
  // This example uses the onOpenDocument event hook to write with the DirectContent layer.
  // It would be better if this layer could be accessed via the main builder block.
  // I.e., it would be more analogous to the iText example.
  // But on the other hand, accessing DirectContent via event hooks might be a more typicaly real use-case.
  onOpenDocument: {writer, document ->
    writer.directContent.with {cb ->
      cb.beginText()
      cb.setFontAndSize(bf, 12)
      cb.moveText(88.66f, 788)
      cb.showText("ld")
      cb.moveText(-22f, 0)
      cb.showText("Wor")
      cb.moveText(-15.33f, 0)
      cb.showText("llo")
      cb.endText()
      PdfTemplate tmp = cb.createTemplate(250, 25)
      tmp.beginText()
      tmp.setFontAndSize(bf, 12)
      tmp.moveText(0, 7)
      tmp.showText("He")
      tmp.endText()
      cb.addTemplate(tmp, 36, 781)
    }
  }
) {
  // nothing in main
}