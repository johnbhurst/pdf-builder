@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Font

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/StandardType1Fonts.pdf")).document() {
  def fonts = [
    new Font(Font.COURIER, Font.DEFAULTSIZE, Font.NORMAL),
    new Font(Font.COURIER, Font.DEFAULTSIZE, Font.ITALIC),
    new Font(Font.COURIER, Font.DEFAULTSIZE, Font.BOLD),
    new Font(Font.COURIER, Font.DEFAULTSIZE, Font.BOLD | Font.ITALIC),
    new Font(Font.HELVETICA, Font.DEFAULTSIZE, Font.NORMAL),
    new Font(Font.HELVETICA, Font.DEFAULTSIZE, Font.ITALIC),
    new Font(Font.HELVETICA, Font.DEFAULTSIZE, Font.BOLD),
    new Font(Font.HELVETICA, Font.DEFAULTSIZE, Font.BOLDITALIC),
    new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.NORMAL),
    new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.ITALIC),
    new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLD),
    new Font(Font.TIMES_ROMAN, Font.DEFAULTSIZE, Font.BOLDITALIC),
    new Font(Font.SYMBOL, Font.DEFAULTSIZE),
    new Font(Font.ZAPFDINGBATS, Font.DEFAULTSIZE, Font.UNDEFINED, new Color(0xFF, 0x00, 0x00))
  ]
  fonts.each {font ->
    paragraph(string: "quick brown fox jumps over the lazy dog", font: font)
  }
}
