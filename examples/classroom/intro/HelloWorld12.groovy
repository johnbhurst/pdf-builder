@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder

def RESULT = "build/examples/classroom/intro/hello12.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  image(filename: "examples/classroom/intro/hello.png", init: { it.scaleToFit(595, 842); it.setAbsolutePosition(0, 0) })
}
