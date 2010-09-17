@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/FontMetrics.pdf")).document() {
  Font font = new Font(Font.HELVETICA, 12)
  BaseFont bf = font.getCalculatedBaseFont(false)
  String numbers = "0123456789"
  String letters = "abcdefghijklmnopqrstuvwxyz"
  paragraph(string: numbers, font: font)
  paragraph(string: "width: ${bf.getWidth(numbers)} (${bf.getWidthPoint(numbers, 12)}pt)", font: font)
  paragraph(string: "ascent: ${bf.getAscent(numbers)}; descent: ${bf.getDescent(numbers)}; " +
            "height: ${bf.getAscentPoint(numbers, 12) - bf.getDescentPoint(numbers, 12) as float}pt", font: font)
  paragraph(string: letters, font: font)
  paragraph(string: "width: ${bf.getWidth(letters)} (${bf.getWidthPoint(letters, 12)}pt)", font: font)
  paragraph(string: "ascent: ${bf.getAscent(letters)}; descent: ${bf.getDescent(letters)}; " +
            "height: ${bf.getAscentPoint(letters, 12) - bf.getDescentPoint(letters, 12) as float}pt", font: font)
}
