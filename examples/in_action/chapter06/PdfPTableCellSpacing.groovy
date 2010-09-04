@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.PdfPCell

def RESULT= "build/examples/in_action/chapter06/PdfPTableCellSpacing.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  table(2, widthPercentage: 100) {
    def table = current
    PdfPCell cell = new PdfPCell(
      new Paragraph(
        "Quick brown fox jumps over the lazy dog. Quick brown fox jumps over the lazy dog."
    ))
    table.addCell("default leading / spacing")
    table.addCell(cell)

    cell.setLeading(20f, 0f)
    table.addCell("absolute leading: 20")
    table.addCell(cell)

    cell.setLeading(3f, 1.2f)
    table.addCell("absolute leading: 3; relative leading: 1.2")
    table.addCell(cell)

    cell.setLeading(0f, 1.2f)
    table.addCell("absolute leading: 0; relative leading: 1.2")
    table.addCell(cell)

    cell.setLeading(0f, 0f)
    table.addCell("no leading at all")
    table.addCell(cell)

    cell = new PdfPCell(new Paragraph("Quick brown fox jumps over the lazy dog."))
    cell.padding = 10
    table.addCell("padding 10")
    table.addCell(cell)

    cell.padding = 0
    table.addCell("padding 0")
    table.addCell(cell)

    cell.paddingLeft = 20
    cell.paddingRight = 50
    cell.paddingTop = 0
    cell.paddingBottom = 5
    table.addCell("different padding for left, right, top and bottom")
    table.addCell(cell)

    Phrase p = new Phrase("Quick brown fox jumps over the lazy dog")
    table.defaultCell.padding = 2
    table.defaultCell.useAscender = false
    table.defaultCell.useDescender = false
    table.addCell("padding 2; no ascender, no descender")
    table.addCell(p)

    table.defaultCell.useAscender = true
    table.defaultCell.useDescender = false
    table.addCell("padding 2; ascender, no descender")
    table.addCell(p)

    table.defaultCell.useAscender = false
    table.defaultCell.useDescender = true
    table.addCell("padding 2; descender, no ascender")
    table.addCell(p)

    table.defaultCell.useAscender = true
    table.defaultCell.useDescender = true
    table.addCell("padding 2; ascender and descender")
    cell.padding = 2
    cell.useAscender = true
    cell.useDescender = true
    table.addCell(p)
  }
}
