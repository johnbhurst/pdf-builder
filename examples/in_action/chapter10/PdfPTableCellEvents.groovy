@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.Phrase
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.GrayColor
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPCellEvent
import com.lowagie.text.pdf.PdfPTable

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/PdfPTableCellEvents.pdf")).document() {
  def border = {PdfPCell cell, Rectangle rect, PdfContentByte[] canvas ->
    canvas[PdfPTable.LINECANVAS].with {
      setColorStroke(new GrayColor(0.8f))
      roundRectangle(rect.left + 4 as float, rect.bottom, rect.width - 8 as float, rect.height - 4 as float, 4)
      stroke()
    }
  } as PdfPCellEvent
  def ellipse = {PdfPCell cell, Rectangle rect, PdfContentByte[] canvas ->
    canvas[PdfPTable.BACKGROUNDCANVAS].with {
      setRGBColorFill(0xFF, 0x00, 0x00)
      ellipse(rect.left, rect.bottom, rect.right, rect.top)
      fill()
      resetRGBColorFill()
    }
  } as PdfPCellEvent
  def strike = {PdfPCell cell, Rectangle rect, PdfContentByte[] canvas ->
    canvas[PdfPTable.TEXTCANVAS].with {
      setRGBColorStroke(0x00, 0x00, 0xFF)
      moveTo(rect.left, rect.bottom)
      lineTo(rect.right, rect.top)
      stroke()
      resetRGBColorStroke()
    }
  } as PdfPCellEvent

  table(6) {
    for (i in 1..30) {
      cell(new Phrase("day $i"), horizontalAlignment: Element.ALIGN_CENTER, border: Rectangle.NO_BORDER, padding: 4) {
        current.setCellEvent(border)
        if (i % 3 == 0) current.setCellEvent(strike)
        if (i % 4 == 0) current.setCellEvent(ellipse)
      }
    }
  }
}
