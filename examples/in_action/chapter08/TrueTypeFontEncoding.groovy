@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

String windowsFontPath(String path) {
  System.properties["windows.font.path"] + "/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/TrueTypeFontEncoding.pdf")).document() {
  BaseFont bf
  Font font

  bf = BaseFont.createFont(windowsFontPath("arialbd.ttf"), "Cp1252", BaseFont.EMBEDDED)
  System.out.println(bf.class.name)
  paragraph("Font: ${bf.postscriptFontName}")
  chunk(Chunk.NEWLINE)
  paragraph("Movie title: A Very long Engagement (France)")
  paragraph("directed by Jean-Pierre Jeunet")
  paragraph("Encoding: ${bf.encoding}")
  font = new Font(bf, 12)
  paragraph(string: "Un long dimanche de fian\u00e7ailles", font: font)
  chunk(Chunk.NEWLINE)

  paragraph("Movie title: No Man's Land (Bosnia-Herzegovina)")
  paragraph("Directed by Danis Tanovic")
  bf = BaseFont.createFont(windowsFontPath("arialbd.ttf"), "Cp1250", BaseFont.EMBEDDED)
  paragraph("Encoding: ${bf.encoding}")
  font = new Font(bf, 12)
  String noMansLand = "Nikogar\u0161nja zemlja"
  paragraph(string: noMansLand, font: font)
  chunk(Chunk.NEWLINE)

  paragraph("Movie title: You I Love (Russia)")
  bf = BaseFont.createFont(windowsFontPath("arialbd.ttf"), "Cp1251", BaseFont.EMBEDDED)
  paragraph("directed by Olga Stolpovskaja and Dmitry Troitsky")
  paragraph("Encoding: ${bf.encoding}")
  font = new Font(bf, 12)
  char[] youILove = [1071, ' ', 1083, 1102, 1073, 1083, 1102, ' ', 1090, 1077, 1073, 1103] as char[]
  paragraph(string: new String(youILove), font: font)
  chunk(Chunk.NEWLINE)

  paragraph("Movie title: Brides (Greece)")
  paragraph("directed by Pantelis Voulgaris")
  bf = BaseFont.createFont(windowsFontPath("arialbd.ttf"), "Cp1253", BaseFont.EMBEDDED)
  paragraph("Encoding: ${bf.encoding}")
  font = new Font(bf, 12)
  byte[] brides = [-51, -3, -10, -27, -14] as byte[]
  paragraph(string: new String(brides, "Cp1253"), font: font)

  document.newPage()
  paragraph("Available code pages")
  bf.codePagesSupported.eachWithIndex {String encoding, i ->
    paragraph("encoding[$i] = $encoding")
  }
  document.newPage()
  paragraph("Full font names:")
  bf.fullFontName.each {names ->
    paragraph("${names[3]} (${names[0]}; ${names[1]}; ${names[2]})")
  }
}
