@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.PageSize
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfPCell

def RESULT= "build/examples/in_action/chapter06/PdfPTableCellHeights.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A5.rotate()) {
  table(2, extendLastRow: true) {
    def table = current
    // wrap / nowrap
    PdfPCell cell = new PdfPCell(
      new Paragraph(
        "blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah"
    ))

    cell.noWrap = false
    table.addCell("wrap")
    table.addCell(cell)

    cell.noWrap = true
    table.addCell("no wrap")
    table.addCell(cell)

    // height
    cell = new PdfPCell(new Paragraph("1. blah blah\n2. blah blah blah\n3. blah blah"))

    cell.fixedHeight = 72
    table.addCell("fixed height (more than sufficient)")
    table.addCell(cell)

    cell.fixedHeight = 36
    table.addCell("fixed height (not sufficient)")
    table.addCell(cell)

    cell = new PdfPCell(new Paragraph("blah blah"))

    cell.minimumHeight = 36
    table.addCell("minimum height")
    table.addCell(cell)

    cell = new PdfPCell(new Paragraph("almost no content, but the row is extended"))
    table.addCell("extend last row")
    table.addCell(cell)
  }
}
