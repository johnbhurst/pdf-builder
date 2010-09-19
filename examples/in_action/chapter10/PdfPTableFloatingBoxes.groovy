@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Paragraph
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPCellEvent
import com.lowagie.text.pdf.PdfPTable
import com.lowagie.text.pdf.PdfPTableEvent

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/PdfPTableFloatingBoxes.pdf")).document() {
  def tableEvent = {PdfPTable table, float[][] width, float[] height, int headerRows, int rowStart, PdfContentByte[] canvases ->
		float[] widths = width[0]
		float x1 = widths[0]
		float x2 = widths[widths.length - 1]
		float y1 = height[0]
		float y2 = height[height.length - 1]
		canvases[PdfPTable.LINECANVAS].with {
      setRGBColorStroke(0x00, 0x00, 0xFF)
      rectangle(x1, y1, x2 - x1 as float, y2 - y1 as float)
      stroke()
      resetRGBColorStroke()
    }
  } as PdfPTableEvent

  def cellEvent = { PdfPCell cell, Rectangle position, PdfContentByte[] canvases ->
		float x1 = position.left + 2
		float x2 = position.right - 2
		float y1 = position.top - 2
		float y2 = position.bottom + 2
		canvases[PdfPTable.LINECANVAS].with {
      setRGBColorStroke(0xFF, 0x00, 0x00)
      rectangle(x1, y1, x2 - x1 as float, y2 - y1 as float)
      stroke()
      resetRGBColorStroke()
    }
  } as PdfPCellEvent

  table(2, tableEvent: tableEvent) {
    current.defaultCell.border = Rectangle.NO_BORDER
    current.defaultCell.cellEvent = cellEvent
    current.defaultCell.padding = 5
    cell("value")
    cell("name")
    cell("fox")
    cell("wolve")
    cell("dog")
    cell("cat")
  }
}
