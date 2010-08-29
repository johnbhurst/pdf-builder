@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.PageSize
import com.lowagie.text.Element

def RESULT= "build/examples/in_action/chapter07/ParagraphText.pdf"
def INPUT = System.getProperty("itext.examples.home") + "/resources/in_action/chapter07/caesar.txt"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4) {
  new File(INPUT).eachLine {line ->
    paragraph("    $line", alignment: Element.ALIGN_JUSTIFIED)
  }
}
