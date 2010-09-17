@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

String resourcePath(String path) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter08/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/CompactFontFormatExample.pdf")).document() {
  BaseFont bf = BaseFont.createFont(resourcePath("esl_gothic_shavian.otf"), "Cp1252", BaseFont.EMBEDDED)
  System.out.println(bf.class.name)
  Font font = new Font(bf, 12)
  paragraph(
    "All human beings are born free and equal in dignity and rights. "
        + "They are endowed with reason and conscience and should act towards one another in a spirit of brotherhood."
  )
  paragraph(
    string: "Yl hVman bIiNz R bPn frI n ikwal in dignitI n rFts. "
        + "Hej R endQd wiH rIzn n konSans n Sud Akt tawPds wan anaHr in a spirit ov braHarhUd.",
    font: font
  )
}
