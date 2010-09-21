@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.PdfContentByte

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/LineCharacteristics.pdf")).document() {
  writer.directContent.withState {PdfContentByte cb ->
    for (int i = 25; i > 0; i--) {
      cb.lineWidth = i / 10 as float
      cb.moveTo(40, 806 - (5 * i) as float)
      cb.lineTo(320, 806 - (5 * i) as float)
      cb.stroke()
    }
  }
  writer.directContent.with {
    moveTo(72, 650)
    lineTo(72, 600)
    moveTo(144, 650)
    lineTo(144, 600)
    stroke()
  }
  writer.directContent.withState {PdfContentByte cb ->
    cb.lineWidth = 8
    cb.lineCap = PdfContentByte.LINE_CAP_BUTT
    cb.moveTo(72, 640)
    cb.lineTo(144, 640)
    cb.stroke()
    cb.lineCap = PdfContentByte.LINE_CAP_ROUND
    cb.moveTo(72, 625)
    cb.lineTo(144, 625)
    cb.stroke()
    cb.lineCap = PdfContentByte.LINE_CAP_PROJECTING_SQUARE
    cb.moveTo(72, 610)
    cb.lineTo(144, 610)
    cb.stroke()
  }
  writer.directContent.withState {PdfContentByte cb ->
    cb.lineWidth = 8
    cb.lineJoin = PdfContentByte.LINE_JOIN_MITER
    cb.moveTo(200, 610)
    cb.lineTo(215, 640)
    cb.lineTo(230, 610)
    cb.stroke()
    cb.lineJoin = PdfContentByte.LINE_JOIN_ROUND
    cb.moveTo(240, 610)
    cb.lineTo(255, 640)
    cb.lineTo(270, 610)
    cb.stroke()
    cb.lineJoin = PdfContentByte.LINE_JOIN_BEVEL
    cb.moveTo(280, 610)
    cb.lineTo(295, 640)
    cb.lineTo(310, 610)
    cb.stroke()
  }
  writer.directContent.withState {PdfContentByte cb ->
    cb.lineWidth = 8
    cb.lineJoin = PdfContentByte.LINE_JOIN_MITER
    cb.miterLimit = 2
    cb.moveTo(75, 560)
    cb.lineTo(95, 590)
    cb.lineTo(115, 560)
    cb.stroke()
    cb.moveTo(116, 560)
    cb.lineTo(135, 590)
    cb.lineTo(154, 560)
    cb.stroke()
    cb.moveTo(157, 560)
    cb.lineTo(175, 590)
    cb.lineTo(193, 560)
    cb.stroke()
    cb.moveTo(198, 560)
    cb.lineTo(215, 590)
    cb.lineTo(232, 560)
    cb.stroke()
    cb.moveTo(239, 560)
    cb.lineTo(255, 590)
    cb.lineTo(271, 560)
    cb.stroke()
    cb.moveTo(280, 560)
    cb.lineTo(295, 590)
    cb.lineTo(310, 560)
    cb.stroke()
  }
  writer.directContent.withState {PdfContentByte cb ->
    cb.lineWidth = 8
    cb.lineJoin = PdfContentByte.LINE_JOIN_MITER
    cb.miterLimit = 2.1
    cb.moveTo(75, 500)
    cb.lineTo(95, 530)
    cb.lineTo(115, 500)
    cb.stroke()
    cb.moveTo(116, 500)
    cb.lineTo(135, 530)
    cb.lineTo(154, 500)
    cb.stroke()
    cb.moveTo(157, 500)
    cb.lineTo(175, 530)
    cb.lineTo(193, 500)
    cb.stroke()
    cb.moveTo(198, 500)
    cb.lineTo(215, 530)
    cb.lineTo(232, 500)
    cb.stroke()
    cb.moveTo(239, 500)
    cb.lineTo(255, 530)
    cb.lineTo(271, 500)
    cb.stroke()
    cb.moveTo(280, 500)
    cb.lineTo(295, 530)
    cb.lineTo(310, 500)
    cb.stroke()
  }
  writer.directContent.withState {PdfContentByte cb ->
    cb.lineWidth = 3
    cb.moveTo(40, 480)
    cb.lineTo(320, 480)
    cb.stroke()
    cb.setLineDash(6, 0)
    cb.moveTo(40, 470)
    cb.lineTo(320, 470)
    cb.stroke()
    cb.setLineDash(6, 3)
    cb.moveTo(40, 460)
    cb.lineTo(320, 460)
    cb.stroke()
    cb.setLineDash(15, 10, 5)
    cb.moveTo(40, 450)
    cb.lineTo(320, 450)
    cb.stroke()
    float[] dash1 = [10, 5, 5, 5, 20] as float[]
    cb.setLineDash(dash1, 5)
    cb.moveTo(40, 440)
    cb.lineTo(320, 440)
    cb.stroke()
    float[] dash2 = [9, 6, 0, 6] as float[]
    cb.lineCap = PdfContentByte.LINE_CAP_ROUND
    cb.setLineDash(dash2, 0)
    cb.moveTo(40, 430)
    cb.lineTo(320, 430)
    cb.stroke()
  }
}
