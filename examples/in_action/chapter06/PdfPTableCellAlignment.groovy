@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.Paragraph

def RESULT= "build/examples/in_action/chapter06/PdfPTableCellAlignment.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  table(2) {
    Paragraph p = new Paragraph("Quick brown fox jumps over the lazy dog. Quick brown fox jumps over the lazy dog.")
    current.addCell("default alignment")
    cell(p)
    current.addCell("centered alignment")
    cell(p, horizontalAlignment: Element.ALIGN_CENTER)
    current.addCell("right alignment")
    cell(p, horizontalAlignment: Element.ALIGN_RIGHT)
    current.addCell("justified alignment")
    cell(p, horizontalAlignment: Element.ALIGN_JUSTIFIED)
    current.addCell("paragraph alignment")
    cell() {
      paragraph("Quick brown fox")
      paragraph("jumps over", alignment: Element.ALIGN_CENTER)
      paragraph("the lazy dog", alignment: Element.ALIGN_RIGHT)
    }
    current.addCell("extra indentation (cell)")
    cell(p, indent: 20)
    current.addCell("extra indentation (paragraph)")
    p.firstLineIndent = 10
    cell {current.addElement(p)}
    current.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
    current.defaultCell.verticalAlignment = Element.ALIGN_BOTTOM
    current.addCell("bottom")
    current.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
    current.defaultCell.verticalAlignment = Element.ALIGN_MIDDLE
    current.addCell("middle")
    current.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
    current.defaultCell.verticalAlignment = Element.ALIGN_TOP
    current.addCell("top")
  }
}
