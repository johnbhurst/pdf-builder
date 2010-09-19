@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.Phrase
import com.lowagie.text.Rectangle
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfPTable
import com.lowagie.text.pdf.PdfPTableEvent
import com.lowagie.text.pdf.PdfAction

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/PdfPTableEvents.pdf")).document() {
  def event = {PdfPTable table, float[][] width, float[] height, int headerRows, int rowStart, PdfContentByte[] canvas ->
    float[] widths = width[0]

    canvas[PdfPTable.TEXTCANVAS].with {
      saveState()
      // border for the complete table
      setLineWidth(2)
      setRGBColorStroke(255, 0, 0)
      rectangle(widths[0], height[height.length - 1], widths[widths.length - 1] - widths[0] as float, height[0] - height[height.length - 1] as float)
      stroke()
      // border for the header rows
      if (headerRows > 0) {
        setRGBColorStroke(0, 0, 255)
        rectangle(widths[0], height[headerRows], widths[widths.length - 1] - widths[0] as float, height[0] - height[headerRows] as float)
        stroke()
      }
      restoreState()
    }
    canvas[PdfPTable.BASECANVAS].with {
      saveState()
      // border for the cells
      setLineWidth(0.5f)
      // loop over the rows
      for (line in 0..height.length-2) {
        widths = width[line]
        // loop over the columns
        for (col in 0..widths.length-2) {
          if (line == 0 && col == 0)
            setAction(
              new PdfAction("http://www.lowagie.com/iText/"),
              widths[col], height[line + 1], widths[col + 1],
              height[line]
            )
          setRGBColorStrokeF(Math.random() as float, Math.random() as float, Math.random() as float)
          // horizontal borderline
          moveTo(widths[col], height[line])
          lineTo(widths[col + 1], height[line])
          stroke()
          // vertical borderline
          setRGBColorStrokeF(Math.random() as float, Math.random() as float, Math.random() as float)
          moveTo(widths[col], height[line])
          lineTo(widths[col], height[line + 1])
          stroke()
        }
      }
      restoreState()
    }
  } as PdfPTableEvent

  def t = table(4, tableEvent: event) {
    current.defaultCell.border = Rectangle.NO_BORDER
    cell("This is an URL")
    for (k in 1..<24) {
      cell("$k")
    }
  }

  // add the table at an absolute position
  t.totalWidth = 300
  t.writeSelectedRows(0, -1, 100, 600, writer.directContent)

  document.newPage()

  table(4, headerRows: 3, tableEvent: event, init: {it.defaultCell.border = Rectangle.NO_BORDER}) {
    current.defaultCell.colspan = 4
    current.defaultCell.horizontalAlignment = Element.ALIGN_CENTER
    cell("This is an URL")
    current.defaultCell.colspan = 1
    current.defaultCell.horizontalAlignment = Element.ALIGN_LEFT
    for (k in 4..<2000) {
      cell("$k")
    }
  }

}
