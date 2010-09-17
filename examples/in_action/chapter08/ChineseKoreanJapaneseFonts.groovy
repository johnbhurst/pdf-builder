@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.Paragraph

String windowsFontPath(String path) {
  System.properties["windows.font.path"] + "/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/ChineseKoreanJapaneseFonts.pdf")).document() {
  BaseFont bf
  Font font
  bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED)
  font = new Font(bf, 12)
  System.out.println(bf.class.name)
  paragraph(string: "Movie title: House of The Flying Daggers (China)", font: font)
  paragraph(string: "directed by Zhang Yimou", font: font)
  paragraph(string: "Font: ${bf.postscriptFontName}", font: font)
  paragraph(string: "\u5341\u950a\u57cb\u4f0f", font: font)

  bf = BaseFont.createFont("KozMinPro-Regular", "UniJIS-UCS2-H", BaseFont.EMBEDDED)
  font = new Font(bf, 12)
  paragraph(string: "Movie title: Nobody Knows (Japan)", font: font)
  paragraph(string: "directed by Hirokazu Koreeda", font: font)
  paragraph(string: "Font: ${bf.postscriptFontName}", font: font)
  paragraph(string: "\u8ab0\u3082\u77e5\u3089\u306a\u3044", font: font)

  bf = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED)
  font = new Font(bf, 12)
  paragraph(string: "Movie title: '3-Iron' aka 'Bin-jip' (South-Korea)", font: font)
  paragraph(string: "directed by Kim Ki-Duk", font: font)
  paragraph(string: "Font: ${bf.postscriptFontName}", font: font)
  paragraph(string: "\ube48\uc9d1", font: font)
}
