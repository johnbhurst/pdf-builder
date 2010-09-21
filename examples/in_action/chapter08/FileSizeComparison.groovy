@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

String windowsFontPath(String path) {
  System.properties["windows.font.location"] + "/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/FileSizeComparisonNotEmbedded.pdf")).document() {
  BaseFont bf_not_embedded = BaseFont.createFont(windowsFontPath("comic.ttf"), BaseFont.CP1252, BaseFont.NOT_EMBEDDED)
  Font font_not_embedded = new Font(bf_not_embedded, 12)
  paragraph(string: "quick brown fox jumps over the lazy dog", font: font_not_embedded)
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/FileSizeComparisonEmbedded1.pdf")).document() {
  BaseFont bf_embedded = BaseFont.createFont(windowsFontPath("comic.ttf"), BaseFont.CP1252, BaseFont.EMBEDDED)
  Font font_embedded = new Font(bf_embedded, 12)
  paragraph(string: "quick brown fox jumps over the lazy dog", font: font_embedded)
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/FileSizeComparisonEmbedded2.pdf")).document() {
  BaseFont bf_embedded = BaseFont.createFont(windowsFontPath("comic.ttf"), BaseFont.CP1252, BaseFont.EMBEDDED)
  Font font_embedded = new Font(bf_embedded, 12)
  paragraph(string: "ooooo ooooo ooo ooooo oooo ooo oooo ooo", font: font_embedded)
}
