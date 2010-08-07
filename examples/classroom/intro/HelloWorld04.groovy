@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.PdfWriter

def RESULT = "build/examples/classroom/intro/hello04.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(
  initWriter: {setEncryption("hello".bytes, "world".bytes, PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128)}
) {
  paragraph("Hello World.")
}
