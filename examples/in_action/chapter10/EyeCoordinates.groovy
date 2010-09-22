@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.geom.AffineTransform
import com.lowagie.text.PageSize

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/EyeCoordinates.pdf")).document() {
  String eye = '''12 w
22.47 64.67 m
37.99 67.76 52.24 75.38 63.43 86.57 c
120 110 m
98.78 110 78.43 101.57 63.43 86.57 c
S
1 J
120 110 m
97.91 110 80 92.09 80 70 c
80 47.91 97.91 30 120 30 c
125 70 m
125 72.76 122.76 75 120 75 c
117.24 75 115 72.76 115 70 c
115 67.24 117.24 65 120 65 c
122.76 65 125 67.24 125 70 c
S
'''
  writer.directContent.withState {cb ->
    cb.setLiteral(eye)
  }
  writer.directContent.withState {cb ->
    cb.concatCTM(1, 0, 0, -1, 0, PageSize.A4.height)
    cb.setLiteral(eye)
  }
  writer.directContent.with {
    transform(AffineTransform.getTranslateInstance(100, 400))
    setLiteral(eye)
    transform(AffineTransform.getRotateInstance(-Math.PI / 2))
    transform(AffineTransform.getScaleInstance(2, 2))
    setLiteral(eye)
  }
}
