@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

String resourcePath(String path) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter08/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/Type1FontFromPFBwithAFM.pdf")).document() {
  BaseFont bf = BaseFont.createFont(resourcePath("putr8a.afm"), "", BaseFont.EMBEDDED)
  Font font = new Font(bf, 12)
  paragraph(string: "0123456789\nabcdefghijklmnopqrstuvwxyz\nABCDEFGHIJKLMNOPQRSTUVWXZ", font: font)
  bf = BaseFont.createFont(resourcePath("cmr10.afm"), "", BaseFont.EMBEDDED)
  font = new Font(bf, 12)
  paragraph(string: "0123456789\nabcdefghijklmnopqrstuvwxyz\nABCDEFGHIJKLMNOPQRSTUVWXZ", font: font)
}
