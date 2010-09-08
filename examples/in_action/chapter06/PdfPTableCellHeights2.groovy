@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.PageSize
import com.lowagie.text.Paragraph

// The original iText example reuses a cell in the wrap/nowrap and height rows.
// This example uses the more natural PDFBuilder node management, and creates
// a new PdfPCell for each cell.  Thus is uses a different sequence of iText calls,
// but in this case produces an identical resulting document.
def RESULT= "build/examples/in_action/chapter06/PdfPTableCellHeights.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A5.rotate()) {
  table(2, extendLastRow: true) {
    // wrap / nowrap
    Paragraph p1 = new Paragraph(
      "blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah"
    )
    cell("wrap")
    cell(p1, noWrap: false)

    cell("no wrap")
    cell(p1, noWrap: true)

    // height
    Paragraph p2 = new Paragraph("1. blah blah\n2. blah blah blah\n3. blah blah")
    cell("fixed height (more than sufficient)")
    cell(p2, fixedHeight: 72)

    cell("fixed height (not sufficient)")
    cell(p2, fixedHeight: 36)

    cell("minimum height")
    cell(new Paragraph("blah blah"), minimumHeight: 36)

    cell("extend last row")
    cell(new Paragraph("almost no content, but the row is extended"))
  }
}
