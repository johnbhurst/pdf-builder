@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.pdf.ShadingColor
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfShading
import com.lowagie.text.pdf.PdfShadingPattern

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter11/ShadingPatterns.pdf")).document() {
  PdfContentByte cb = writer.directContent
  PdfShading axial = PdfShading.simpleAxial(writer, 36, 716, 396, 788, Color.orange, Color.blue)
  cb.paintShading(axial)
  PdfShading radial = PdfShading.simpleRadial(writer, 200, 500, 50, 300, 500, 100, new Color(255, 247, 148), new Color(247, 138, 107), false, false)
  cb.paintShading(radial)
  document.newPage()

  PdfShadingPattern axialPattern = new PdfShadingPattern(axial)
  cb.setShadingFill(axialPattern)
  cb.rectangle(36, 716, 72, 72)
  cb.rectangle(144, 716, 72, 72)
  cb.rectangle(252, 716, 72, 72)
  cb.rectangle(360, 716, 72, 72)
  cb.fillStroke()

  ShadingColor axialColor = new ShadingColor(axialPattern)
  cb.setColorFill(axialColor)
  cb.rectangle(36, 608, 72, 72)
  cb.rectangle(144, 608, 72, 72)
  cb.rectangle(252, 608, 72, 72)
  cb.rectangle(360, 608, 72, 72)
  cb.fillStroke()
  PdfShadingPattern radialPattern = new PdfShadingPattern(radial)
  ShadingColor radialColor = new ShadingColor(radialPattern)
  cb.setColorFill(radialColor)
  cb.rectangle(36, 500, 72, 72)
  cb.rectangle(144, 500, 72, 72)
  cb.rectangle(252, 500, 72, 72)
  cb.rectangle(360, 500, 72, 72)
  cb.fillStroke()
}
