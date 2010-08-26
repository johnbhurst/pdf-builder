@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.draw.VerticalPositionMark;

pascal = [:].withDefault {i ->
  [:].withDefault {j ->
    if (i == 0 || i == 1) 1
    else if (j == 0 || j == i) 1
    else pascal[i-1][j-1] + pascal[i-1][j]
  }
}
def vp = new VerticalPositionMark()

def RESULT = "build/examples/questions/separators/PascalsTriangle.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  for (i in 0..20) {
    paragraph(chunk(vp)) {
      for (j in 0..i) {
        chunk("" + pascal[i][j])
        chunk(vp)
      }
    }
  }
}
