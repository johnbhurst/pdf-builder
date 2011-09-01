@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Font
import com.lowagie.text.Image
import com.lowagie.text.pdf.CMYKColor
import com.lowagie.text.pdf.PatternColor
import com.lowagie.text.pdf.ShadingColor
import com.lowagie.text.pdf.SpotColor
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfPatternPainter
import com.lowagie.text.pdf.PdfShading
import com.lowagie.text.pdf.PdfShadingPattern
import com.lowagie.text.pdf.PdfSpotColor

String resourcePath(String path) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + path
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter11/ColoredParagraphs.pdf")).document() {
  PdfContentByte cb = writer.directContent

  PdfSpotColor psc_cmyk = new PdfSpotColor("iTextSpotColorCMYK", 1, new CMYKColor(0.3f, 0.9f, 0.3f, 0.1f))
  SpotColor sc_cmyk = new SpotColor(psc_cmyk, 0.25f)

  Image img = Image.getInstance(resourcePath("foxdog.jpg"))
  PdfPatternPainter img_pattern = cb.createPattern(img.scaledWidth, img.scaledHeight, img.scaledWidth, img.scaledHeight)
  img_pattern.addImage(img, img.getScaledWidth(), 0f, 0f, img.getScaledHeight(), 0f, 0f)
  img_pattern.setPatternMatrix(1f, 0f, 0f, 1f, 60f, 60f)
  PatternColor img_color = new PatternColor(img_pattern)

  PdfShading axial = PdfShading.simpleAxial(writer, 36, 716, 396, 788, Color.orange, Color.blue)
  PdfShadingPattern axialPattern = new PdfShadingPattern(axial)
  ShadingColor axialColor = new ShadingColor(axialPattern)

  paragraph(string: "This is a paragraph painted using a SpotColor", font: new Font(Font.HELVETICA, 24, Font.BOLD, sc_cmyk))
  paragraph(string: "This is a paragraph painted using an image pattern", font: new Font(Font.HELVETICA, 24, Font.BOLD, img_color))
  paragraph(string: "This is a paragraph painted using a shading pattern", font: new Font(Font.HELVETICA, 24, Font.BOLD, axialColor))
}
