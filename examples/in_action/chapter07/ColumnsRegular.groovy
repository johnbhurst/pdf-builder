@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.PageSize
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.ColumnText

def RESULT= "build/examples/in_action/chapter07/ColumnsRegular.pdf"
def INPUT = System.getProperty("itext.examples.home") + "/resources/in_action/chapter07/caesar.txt"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4) {
  String text = new File(INPUT).text
  ColumnText ct = new ColumnText(writer.directContent)
  ct.alignment = Element.ALIGN_JUSTIFIED
  ct.setText(new Phrase(text))
  def left = [36, PageSize.A4.width / 2 + 18]
  def right = [PageSize.A4.width / 2 - 18, PageSize.A4.width - 36]
  int status = ColumnText.START_COLUMN
  int column = 0
  while (ColumnText.hasMoreText(status)) {
    ct.setSimpleColumn(left[column] as float, 36, right[column] as float, PageSize.A4.height - 36 as float)
    status = ct.go()
    column = 1 - column
    if (column == 0) {
      document.newPage()
    }
  }
}
