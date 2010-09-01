@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Paragraph

// This example uses the perhaps more natural "builder" way of creating and adding nodes.
// But, because PdfPTable.addCell(String) gives different results from addCell(new PdfPCell(new Phrase(String)))m
// this gives a different-looking table from the original example.
// It would be nice if we could do cell(String).
def RESULT= "build/examples/in_action/chapter06/MyFirstPdfPTable2.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  table(3) {
    cell(new Paragraph("header with colspan 3"), colspan: 3)
    cell {phrase "1.1"} ; cell {phrase "2.1"} ; cell {phrase "3.1"}
    cell {phrase "1.2"} ; cell {phrase "2.2"} ; cell {phrase "3.2"}
  }
}
