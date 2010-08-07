// Add in ~/.groovy/grapeConfig.xml:
//       <ibiblio name="skepticalhumorist01" root="http://skepticalhumorist.co.nz/artifactory/repo" m2compatible="true"/>
// This is required until this library gets into a public repo.

@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder

new PDFBuilder(outputStream: new File("Hello.pdf").newOutputStream()).document() {
  paragraph("Hello from iText.")
}
