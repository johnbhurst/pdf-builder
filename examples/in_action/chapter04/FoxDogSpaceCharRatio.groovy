@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Element
import com.lowagie.text.PageSize
import com.lowagie.text.pdf.PdfWriter

def RESULT= "build/examples/in_action/chapter04/FoxDogSpaceCharRatio.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A8.rotate()) {
  String text = "Quick brown fox jumps over the lazy dog."
  paragraph(text, alignment: Element.ALIGN_JUSTIFIED)
  document.newPage()
  writer.setSpaceCharRatio(PdfWriter.NO_SPACE_CHAR_RATIO)
  paragraph(text, alignment: Element.ALIGN_JUSTIFIED)
}
