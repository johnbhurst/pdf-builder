@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.BaseFont

String resourcePath(String path) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter08/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/CIDTrueTypeOutlines.pdf")).document() {
  BaseFont bf = BaseFont.createFont(resourcePath("esl_gothic_unicode.ttf"), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED)
  Font font = new Font(bf, 12)
  System.out.println(bf.class.name)
  paragraph(
    string: "All human beings are born free and equal in dignity and rights. " +
      "They are endowed with reason and conscience and should act towards one another in a spirit of brotherhood.",
    font: font
  )
  paragraph(
    string: "\ue727\ue714 \ue713\ue72f\ue715\ue719\ue71f \ue70a\ue720\ue716\ue709\ue70f \ue728 " +
      "\ue70a\ue729\ue71f \ue703\ue71e\ue720 \ue71f \ue716\ue702\ue712\ue71a\ue714 \ue716\ue71f " +
      "\ue70b\ue716\ue70c\ue71f\ue716\ue701\ue720 \ue71f \ue71e\ue722\ue701\ue705. " +
      "\ue70e\ue717\ue708 \ue728 \ue717\ue71f\ue70b\ue71c\ue70b \ue712\ue716\ue70e \ue71e\ue720\ue70f\ue71f " +
      "\ue71f \ue702\ue71a\ue71f\ue706\ue719\ue71f\ue705 \ue71f \ue706\ue723\ue70b " +
      "\ue718\ue702\ue701 \ue701\ue719\ue712\ue729\ue70b\ue70f \ue712\ue719\ue71f " +
      "\ue719\ue71f\ue719\ue70e\ue71e \ue716\ue71f \ue419 \ue719 \ue705\ue700\ue716\ue71e\ue716\ue701 " +
      "\ue71a\ue70d \ue70a\ue71e\ue719\ue70e\ue719\ue71e\ue713\ue71b\ue70b.",
    font: font
  )
}
