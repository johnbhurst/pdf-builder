@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

String windowsFontPath(String path) {
  System.properties["windows.font.location"] + "/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/TrueTypeFontExample.pdf")).document() {
  BaseFont bf = BaseFont.createFont(windowsFontPath("arbli___.ttf"), BaseFont.CP1252, BaseFont.EMBEDDED)
  Font font = new Font(bf, 12)
  System.out.println(bf.class.name)
  paragraph(string: "This is font arial black italic (embedded)", font: font)
  bf = BaseFont.createFont(windowsFontPath("arbli___.ttf"), BaseFont.CP1252, BaseFont.NOT_EMBEDDED)
  font = new Font(bf, 12)
  paragraph(string: "This is font arial black italic (not embedded)", font: font)
  paragraph("PostScript name:${bf.postscriptFontName}")
  paragraph("Available code pages:")
  bf.codePagesSupported.eachWithIndex {String encoding, i ->
    paragraph("encoding[$i] = ${encoding[i]}")
  }
  document.newPage()
  paragraph("Full font names:")
  bf.fullFontName.each {String[] names ->
    paragraph("${names[3]} (${names[0]}; ${names[1]}; ${names[2]})")
  }
}
