@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfTemplate
import com.lowagie.text.PageSize
import static Math.sqrt

String resourcePath(String path) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter10/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/EyeTemplate.pdf")).document() {
  PdfTemplate template = writer.directContent.createTemplate(150, 150)
  template.setLineWidth(12)
  template.arc(
    40 - sqrt(12800) as float,
    110 + sqrt(12800) as float,
    200 - sqrt(12800) as float,
    -50 + sqrt(12800) as float,
    281.25 as float,
    33.75 as float
  )
  template.arc(40f, 110f, 200f, -50f, 90f, 45f)
  template.stroke()
  template.lineCap = PdfContentByte.LINE_JOIN_ROUND
  template.arc(80, 30, 160, 110, 90, 180)
  template.arc(115, 65, 125, 75, 0, 360)
  template.stroke()
  writer.directContent.with {
    addTemplate(template, 0, 0)
    addTemplate(template, 1, 0, 0, -1, 0, PageSize.A4.height)
    addTemplate(template, 100, 400)
    addTemplate(template, 0, -2, 2, 0, 100, 400)
  }
}
