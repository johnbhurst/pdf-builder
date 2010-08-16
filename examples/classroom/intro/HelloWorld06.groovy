@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.BaseFont

def RESULT = "build/examples/classroom/intro/hello06.pdf"
BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  writer.directContent.with {cb ->
    cb.beginText()
    cb.setTextMatrix(36, 788)
    cb.setFontAndSize(bf, 12)
    cb.showText("Hello World")
    cb.endText()
  }
}
