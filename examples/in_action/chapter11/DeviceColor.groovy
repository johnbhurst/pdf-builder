@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.pdf.CMYKColor
import com.lowagie.text.pdf.GrayColor
import com.lowagie.text.pdf.PdfContentByte

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter11/DeviceColor.pdf")).document() {
  PdfContentByte cb = writer.directContent
  [
    [0     ,  36, 770, 36, 36],
    [0.125f,  90, 770, 36, 36],
    [0.25f , 144, 770, 36, 36],
    [0.375f, 198, 770, 36, 36],
    [0.5f  , 252, 770, 36, 36],
    [0.625f, 306, 770, 36, 36],
    [191   , 360, 770, 36, 36],
    [223   , 416, 770, 36, 36],
    [255   , 470, 770, 36, 36]
  ].each {
    cb.setColorFill(new GrayColor(it[0]))
    cb.rectangle(it[1], it[2], it[3], it[4])
    cb.fillStroke()
  }
  [
    [0     ,  36, 716, 36, 36],
    [0.125f,  90, 716, 36, 36],
    [0.25f , 144, 716, 36, 36],
    [0.375f, 198, 716, 36, 36],
    [0.5f  , 252, 716, 36, 36],
    [0.625f, 306, 716, 36, 36],
    [0.75f , 360, 716, 36, 36],
    [0.875f, 416, 716, 36, 36],
    [1     , 470, 716, 36, 36]
  ].each {
    cb.setGrayFill(it[0])
    cb.rectangle(it[1], it[2], it[3], it[4])
    cb.fillStroke()
  }
  [
    [0x00, 0x00, 0x00,  36, 662, 36, 36],
    [0x00, 0x00, 0xFF,  90, 662, 36, 36],
    [0x00, 0xFF, 0x00, 144, 662, 36, 36],
    [0x00, 0xFF, 0xFF, 198, 662, 36, 36],
    [1f  , 0f  , 0f  , 252, 662, 36, 36],
    [1f  , 0   , 1f  , 306, 662, 36, 36],
    [1f  , 1f  , 0   , 360, 662, 36, 36],
    [1f  , 1f  , 1f  , 416, 662, 36, 36]
  ].each {
    cb.setColorFill(new Color(it[0], it[1], it[2]))
    cb.rectangle(it[3], it[4], it[5], it[6])
    cb.fillStroke()
  }
  [
    [0x00, 0x00, 0x00,  36, 608, 36, 36],
    [0x00, 0x00, 0xFF,  90, 608, 36, 36],
    [0x00, 0xFF, 0x00, 144, 608, 36, 36],
    [0x00, 0xFF, 0xFF, 198, 608, 36, 36]
  ].each {
    cb.setRGBColorFill(it[0], it[1], it[2])
    cb.rectangle(it[3], it[4], it[5], it[6])
    cb.fillStroke()
  }
  [
    [1f, 0f, 0f, 252, 608, 36, 36],
    [1f, 0f, 1f, 306, 608, 36, 36],
    [1f, 1f, 0f, 360, 608, 36, 36],
    [1f, 1f, 1f, 416, 608, 36, 36]
  ].each {
    cb.setRGBColorFillF(it[0], it[1], it[2])
    cb.rectangle(it[3], it[4], it[5], it[6])
    cb.fillStroke()
  }
  [
    [0x00, 0x00, 0x00, 0x00,  36, 554, 36, 36],
    [0x00, 0x00, 0xFF, 0x00,  90, 554, 36, 36],
    [0x00, 0x00, 0xFF, 0x0F, 144, 554, 36, 36],
    [0x00, 0xFF, 0x00, 0x00, 198, 554, 36, 36],
    [0f  , 1f  , 0f  , 0.5f, 252, 554, 36, 36],
    [1f  , 0f  , 0f  , 0f  , 306, 554, 36, 36],
    [1f  , 0f  , 0f  , 0.5f, 360, 554, 36, 36],
    [0f  , 0f  , 0f  , 1f  , 416, 554, 36, 36]
  ].each {
    cb.setColorFill(new CMYKColor(it[0], it[1], it[2], it[3]))
    cb.rectangle(it[4], it[5], it[6], it[7])
    cb.fillStroke()
  }
  [
    [0x00, 0x00, 0x00, 0x00,  36, 500, 36, 36],
    [0x00, 0xFF, 0xFF, 0x00,  90, 500, 36, 36],
    [0x00, 0xFF, 0xFF, 0x0F, 144, 500, 36, 36],
    [0xFF, 0xFF, 0x00, 0x00, 198, 500, 36, 36]
  ].each {
    cb.setCMYKColorFill(it[0], it[1], it[2], it[3])
    cb.rectangle(it[4], it[5], it[6], it[7])
    cb.fillStroke()
  }
  [
    [1f, 1f, 0f, 0.5f, 252, 500, 36, 36],
    [1f, 0f, 1f, 0f  , 306, 500, 36, 36],
    [1f, 0f, 1f, 0.5f, 360, 500, 36, 36],
    [0f, 0f, 0f, 1f  , 416, 500, 36, 36]
  ].each {
    cb.setCMYKColorFillF(it[0], it[1], it[2], it[3])
    cb.rectangle(it[4], it[5], it[6], it[7])
    cb.fillStroke()
  }
}
