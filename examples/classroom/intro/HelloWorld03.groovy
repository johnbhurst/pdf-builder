@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder

def RESULT = "build/examples/classroom/intro/hello03.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(
  initWriter: {setFullCompression()}
) {
  paragraph("Hello World.")
}
