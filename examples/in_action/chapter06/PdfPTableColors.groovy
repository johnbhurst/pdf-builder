@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.PageSize
import com.lowagie.text.Paragraph
import com.lowagie.text.Rectangle

def RESULT= "build/examples/in_action/chapter06/PdfPTableColors.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4.rotate()) {
  table(4, widthPercentage: 100) {
    cell(new Paragraph("test colors:"))
    cell(new Paragraph("red / no borders"), border: Rectangle.NO_BORDER, backgroundColor: Color.red)
    cell(new Paragraph("green / magenta bottom border"), border: Rectangle.BOTTOM, borderColorBottom: Color.magenta, borderWidthBottom: 10, backgroundColor: Color.green)
    cell(new Paragraph("blue / cyan top border + padding"), border: Rectangle.TOP, useBorderPadding: true, borderWidthTop: 5, borderColorTop: Color.cyan, backgroundColor: Color.blue)

    cell(new Paragraph("test GrayFill:"))
    cell(new Paragraph("0.25"), border: Rectangle.NO_BORDER, grayFill: 0.25)
    cell(new Paragraph("0.5"), border: Rectangle.NO_BORDER, grayFill: 0.5)
    cell(new Paragraph("0.75"), border: Rectangle.NO_BORDER, grayFill: 0.75)

    cell(new Paragraph("test bordercolors:"))
    cell(new Paragraph("different borders"), borderWidthLeft: 6, borderWidthBottom: 5, borderWidthRight: 4, borderWidthTop: 2, borderColorLeft: Color.red, borderColorBottom: Color.orange, borderColorRight: Color.yellow, borderColorTop: Color.green)
    cell(new Paragraph("with correct padding"), useBorderPadding: true, borderWidthLeft: 6, borderWidthBottom: 5, borderWidthRight: 4, borderWidthTop: 2, borderColorLeft: Color.red, borderColorBottom: Color.orange, borderColorRight: Color.yellow, borderColorTop: Color.green)
    cell(new Paragraph("orange border"), borderWidth: 6, borderColor: Color.orange)
  }
}
