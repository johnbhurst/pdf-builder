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
import com.lowagie.text.Element
import com.lowagie.text.pdf.PdfTransparencyGroup
import com.lowagie.text.pdf.PdfTemplate
import com.lowagie.text.pdf.PdfGState
import com.lowagie.text.pdf.ColumnText
import com.lowagie.text.Phrase

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter11/Transparency1.pdf")).document() {
  def pictureBackdrop = {float x, float y, PdfContentByte cb ->
    cb.colorStroke = Color.black
    cb.colorFill = Color.gray
    cb.rectangle(x, y, 100, 200)
    cb.fill()
    cb.lineWidth = 2
    cb.rectangle(x, y, 200, 200)
    cb.stroke()
  }

  def pictureCircles = {float x, float y, PdfContentByte cb ->
    cb.colorFill = Color.red
    cb.circle(x + 70, y + 70, 50)
    cb.fill()
    cb.colorFill = Color.yellow
    cb.circle(x + 100, y + 130, 50)
    cb.fill()
    cb.colorFill = Color.blue
    cb.circle(x + 130, y + 70, 50)
    cb.fill()
	}

  float gap = (document.pageSize.width - 400) / 3 as float

  writer.directContent
  pictureBackdrop(gap, 500)
  pictureBackdrop(200 + 2 * gap, 500, cb)
  pictureBackdrop(gap, 500 - 200 - gap, cb)
  pictureBackdrop(200 + 2 * gap, 500 - 200 - gap, cb)

  pictureCircles(gap, 500, cb)
  writer.directContent.withState {cb ->
    PdfGState gs1 = new PdfGState()
    gs1.setFillOpacity(0.5f)
    cb.setGState(gs1)
    pictureCircles(200 + 2 * gap, 500, cb)
  }

  PdfTemplate tp = cb.createTemplate(200, 200)
  cb.saveState()
  pictureCircles(0, 0, tp)
  PdfTransparencyGroup group = new PdfTransparencyGroup()
  tp.setGroup(group)
  cb.setGState(gs1)
  cb.addTemplate(tp, gap, 500 - 200 - gap)
  cb.restoreState()

  tp = cb.createTemplate(200, 200)
  cb.saveState()
  PdfGState gs2 = new PdfGState()
  gs2.setFillOpacity(0.5f)
  gs2.setBlendMode(PdfGState.BM_SOFTLIGHT)
  tp.setGState(gs2)
  pictureCircles(0, 0, tp)
  tp.setGroup(group)
  cb.addTemplate(tp, 200 + 2 * gap, 500 - 200 - gap)
  cb.restoreState()

  cb.resetRGBColorFill()
  ColumnText ct = new ColumnText(cb)
  Phrase ph = new Phrase("Ungrouped objects\nObject opacity = 1.0")
  ct.setSimpleColumn(ph, gap, 0, gap + 200, 500, 18,
      Element.ALIGN_CENTER)
  ct.go()

  ph = new Phrase("Ungrouped objects\nObject opacity = 0.5")
  ct.setSimpleColumn(ph, 200 + 2 * gap, 0, 200 + 2 * gap + 200, 500,
      18, Element.ALIGN_CENTER)
  ct.go()

  ph = new Phrase(
      "Transparency group\nObject opacity = 1.0\nGroup opacity = 0.5\nBlend mode = Normal")
  ct.setSimpleColumn(ph, gap, 0, gap + 200, 500 - 200 - gap, 18,
      Element.ALIGN_CENTER)
  ct.go()

  ph = new Phrase(
      "Transparency group\nObject opacity = 0.5\nGroup opacity = 1.0\nBlend mode = SoftLight")
  ct.setSimpleColumn(ph, 200 + 2 * gap, 0, 200 + 2 * gap + 200,
      500 - 200 - gap, 18, Element.ALIGN_CENTER)
  ct.go()
}
