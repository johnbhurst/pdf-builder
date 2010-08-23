@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.draw.VerticalPositionMark;

pascal = [:].withDefault {k ->
  [:].withDefault {i ->
    if (k == 0 || k == 1) 1
    else if (i == 0 || i == k) 1
    else pascal[k-1][i-1] + pascal[k-1][i]
  }
}
def vp = new VerticalPositionMark()

def RESULT = "build/examples/questions/separators/PascalsTriangle.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  for (k in 0..20) {
    paragraph(chunk(vp)) {
      for (i in 0..k) {
        chunk("" + pascal[k][i])
        chunk(vp)
      }
    }
  }
}
