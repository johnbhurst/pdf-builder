@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.PageSize
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.ColumnText

def RESULT= "build/examples/in_action/chapter07/ColumnWithSetText.pdf"
def INPUT = System.getProperty("itext.examples.home") + "/resources/in_action/chapter07/caesar.txt"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4) {
  String text = new File(INPUT).text
  ColumnText ct = new ColumnText(writer.directContent)
  ct.setSimpleColumn(36, 36, PageSize.A4.width - 36 as float, PageSize.A4.height - 36 as float, 18, Element.ALIGN_JUSTIFIED)
  ct.setText(new Phrase(text))
  int status = ColumnText.START_COLUMN
  while (ColumnText.hasMoreText(status)) {
    status = ct.go()
    ct.setYLine(PageSize.A4.height - 36 as float)
    document.newPage()
  }
}
