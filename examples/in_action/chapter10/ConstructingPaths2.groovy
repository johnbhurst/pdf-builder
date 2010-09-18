@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.GrayColor

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/ConstructingPaths2.pdf")).document() {
  writer.directContent.metaClass.curveTo = {Double x1, Double y1, Double x2, Double y2, Double x3, Double y3 ->
    curveTo(x1 as float, y1 as float, x2 as float, y2 as float, x3 as float, y3 as float)
  }
  writer.directContent.metaClass.constructStar = {x, y ->
    moveTo(x + 10, y)
    lineTo(x + 80, y + 60)
    lineTo(x, y + 60)
    lineTo(x + 70, y)
    lineTo(x + 40, y + 90)
    closePath()
  }
  writer.directContent.metaClass.constructCircle = {x, y, r, clockwise ->
    float b = 0.5523f
    if (clockwise) {
      moveTo(x + r, y)
      curveTo(x + r, y - r * b, x + r * b, y - r, x, y - r)
      curveTo(x - r * b, y - r, x - r, y - r * b, x - r, y)
      curveTo(x - r, y + r * b, x - r * b, y + r, x, y + r)
      curveTo(x + r * b, y + r, x + r, y + r * b, x + r, y)
    } else {
      moveTo(x + r, y)
      curveTo(x + r, y + r * b, x + r * b, y + r, x, y + r)
      curveTo(x - r * b, y + r, x - r, y + r * b, x - r, y)
      curveTo(x - r, y - r * b, x - r * b, y - r, x, y - r)
      curveTo(x + r * b, y - r, x + r, y - r * b, x + r, y)
    }
  }
  writer.directContent.with {
    setColorStroke(new GrayColor(0.2f))
    setColorFill(new GrayColor(0.9f))
    constructStar(30, 720)
    constructCircle(70, 650, 40, true)
    constructCircle(70, 650, 20, true)
    fill()
    constructStar(120, 720)
    constructCircle(160, 650, 40, true)
    constructCircle(160, 650, 20, true)
    eoFill()
    constructStar(250, 650)
    newPath()
    constructCircle(250, 650, 40, true)
    constructCircle(250, 650, 20, true)
    constructStar(300, 720)
    constructCircle(340, 650, 40, true)
    constructCircle(340, 650, 20, false)
    fillStroke()
    constructStar(390, 720)
    constructCircle(430, 650, 40, true)
    constructCircle(430, 650, 20, true)
    eoFillStroke()
  }
}
