@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Document

def RESULT = "build/examples/classroom/intro/hello02.pdf"
Document.compress = false
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  paragraph("Hello World.")
}
