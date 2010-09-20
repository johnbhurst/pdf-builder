@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

String windowsFontPath(String path) {
  System.properties["windows.font.location"] + "/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/TrueTypeCollections.pdf")).document() {
  BaseFont bf = BaseFont.createFont(windowsFontPath("msgothic.ttc,0"), BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
  Font font = new Font(bf, 12)
  System.out.println(bf.class.name)
  paragraph(string: "Rash\u00f4mon", font: font)
  paragraph(string: "Directed by Akira Kurosawa", font: font)
  paragraph(string: "\u7f85\u751f\u9580", font: font)
  BaseFont.enumerateTTCNames(windowsFontPath("msgothic.ttc")).eachWithIndex {name, i ->
    paragraph(string: "font $i: ${name}", font: font)
  }
}
