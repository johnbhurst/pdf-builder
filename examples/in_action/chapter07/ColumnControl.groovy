@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.PageSize
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.ColumnText

def RESULT= "build/examples/in_action/chapter07/ColumnControl.pdf"
def INPUT = System.getProperty("itext.examples.home") + "/resources/in_action/chapter07/caesar.txt"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4) {
  ColumnText ct = new ColumnText(writer.directContent)
  ct.setSimpleColumn(36, 36, PageSize.A4.width - 36 as float, PageSize.A4.height - 36 as float, 18, Element.ALIGN_JUSTIFIED)
  new File(INPUT).eachLine {line ->
    def phrase = new Phrase(line)
    ct.addText(phrase)
    float pos = ct.YLine
    if (ColumnText.hasMoreText(ct.go(true))) {
      document.newPage()
      ct.setText(phrase)
      ct.YLine = PageSize.A4.height - 36 as float
      ct.go()
    }
    else {
      ct.addText(phrase)
      ct.YLine = pos
      ct.go(false)
    }
  }
}
