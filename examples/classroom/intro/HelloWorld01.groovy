@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder

def RESULT = "build/examples/classroom/intro/hello01.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  paragraph("Hello World.")
}
