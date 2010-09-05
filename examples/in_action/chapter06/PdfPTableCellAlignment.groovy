@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.Paragraph

def RESULT= "build/examples/in_action/chapter06/PdfPTableCellAlignment.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  table(2) {
    Paragraph p = new Paragraph("Quick brown fox jumps over the lazy dog. Quick brown fox jumps over the lazy dog.")
    cell("default alignment")
    cell(p)
    cell("centered alignment")
    cell(p, horizontalAlignment: Element.ALIGN_CENTER)
    cell("right alignment")
    cell(p, horizontalAlignment: Element.ALIGN_RIGHT)
    cell("justified alignment")
    cell(p, horizontalAlignment: Element.ALIGN_JUSTIFIED)
    cell("paragraph alignment")
    cell() {
      paragraph("Quick brown fox")
      paragraph("jumps over", alignment: Element.ALIGN_CENTER)
      paragraph("the lazy dog", alignment: Element.ALIGN_RIGHT)
    }
    cell("extra indentation (cell)")
    cell(p, indent: 20)
    cell("extra indentation (paragraph)")
    p.firstLineIndent = 10
    cell {current.addElement(p)}
    cell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
    current.defaultCell.verticalAlignment = Element.ALIGN_BOTTOM
    cell("bottom")
    cell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
    current.defaultCell.verticalAlignment = Element.ALIGN_MIDDLE
    cell("middle")
    cell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
    current.defaultCell.verticalAlignment = Element.ALIGN_TOP
    cell("top")
  }
}
