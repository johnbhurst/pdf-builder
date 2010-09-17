@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

String resourcePath(String path) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter08/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/Type1FontFromAFM.pdf")).document() {
  BaseFont bf1 = BaseFont.createFont("/com/lowagie/text/pdf/fonts/Times-Roman.afm", "", BaseFont.NOT_EMBEDDED)
  Font font1 = new Font(bf1, 12)
  paragraph(string: "0123456789\nabcdefghijklmnopqrstuvwxyz\nABCDEFGHIJKLMNOPQRSTUVWXZ", font: font1)
  BaseFont bf2 = BaseFont.createFont(resourcePath("putr8a.afm"), "", BaseFont.NOT_EMBEDDED)
  Font font2 = new Font(bf2, 12)
  paragraph(string: "0123456789\nabcdefghijklmnopqrstuvwxyz\nABCDEFGHIJKLMNOPQRSTUVWXZ", font: font2)
  BaseFont bf3 = BaseFont.createFont(resourcePath("cmr10.afm"), "", BaseFont.NOT_EMBEDDED)
  Font font3 = new Font(bf3, 12)
  paragraph(string: "0123456789\nabcdefghijklmnopqrstuvwxyz\nABCDEFGHIJKLMNOPQRSTUVWXZ", font: font3)
}
