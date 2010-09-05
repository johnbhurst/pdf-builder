@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.Element
import com.lowagie.text.PageSize

def RESULT= "build/examples/in_action/chapter06/PdfPTableCompare.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4) {
  paragraph("The table below is added with document.add():")
  chunk(Chunk.NEWLINE)
  // Note: below creates the table, adds it to the document, and also stores it in variable for reuse
  def table = table(3) {
    current.defaultCell.horizontalAlignment = Element.ALIGN_CENTER
    cell("the quick brown fox")
    cell("jumps over")
    cell("the lazy dog")
    cell("the lazy dog")
    cell("jumps over")
    cell("the quick brown fox")
  }
  paragraph("The table below is added with writeSelectedRows() at position (x = 50; y = ${PageSize.A4.height * 0.75}):")
  table.writeSelectedRows(0, -1, 50, PageSize.A4.height * 0.75 as float, writer.directContent)
}
