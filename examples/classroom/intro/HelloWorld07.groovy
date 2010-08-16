@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.Element

def RESULT = "build/examples/classroom/intro/hello07.pdf"
BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  writer.directContent.with {cb ->
    cb.beginText()
    cb.setFontAndSize(bf, 12)
    cb.showTextAligned(Element.ALIGN_LEFT, "Hello World", 36, 788, 0)
    cb.endText()
  }
}
