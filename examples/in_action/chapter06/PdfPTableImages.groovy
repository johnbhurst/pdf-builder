@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Image

def RESULT= "build/examples/in_action/chapter06/PdfPTableImages.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  table(1) {
    def table = current
    Image img = Image.getInstance(System.getProperty("itext.examples.home") + "/resources/in_action/chapter06/foxdog.jpg")
    cell("This image was added with addCell(Image); the image is scaled + there is the default padding of getDefaultCell.")
    table.addCell(img);
    cell("This image was added with addCell(PdfPCell); scaled, no padding")
    cell(image: img, fit: true)
    cell("This image was added with addCell(PdfPCell); not scaled")
    cell(image: img, fit: false)
  }
}
