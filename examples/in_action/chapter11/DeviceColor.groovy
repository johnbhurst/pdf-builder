@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.pdf.CMYKColor
import com.lowagie.text.pdf.GrayColor

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter11/DeviceColor.pdf")).document() {
  writer.directContent.with {
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
    ].each {c, x, y, w, h ->
      setColorFill(new GrayColor(c))
      rectangle(x, y, w, h)
      fillStroke()
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
    ].each {c, x, y, w, h ->
      setGrayFill(c)
      rectangle(x, y, w, h)
      fillStroke()
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
    ].each {r, g, b, x, y, w, h ->
      setColorFill(new Color(r, g, b))
      rectangle(x, y, w, h)
      fillStroke()
    }
    [
      [0x00, 0x00, 0x00,  36, 608, 36, 36],
      [0x00, 0x00, 0xFF,  90, 608, 36, 36],
      [0x00, 0xFF, 0x00, 144, 608, 36, 36],
      [0x00, 0xFF, 0xFF, 198, 608, 36, 36]
    ].each {r, g, b, x, y, w, h ->
      setRGBColorFill(r, g, b)
      rectangle(x, y, w, h)
      fillStroke()
    }
    [
      [1f, 0f, 0f, 252, 608, 36, 36],
      [1f, 0f, 1f, 306, 608, 36, 36],
      [1f, 1f, 0f, 360, 608, 36, 36],
      [1f, 1f, 1f, 416, 608, 36, 36]
    ].each {r, g, b, x, y, w, h ->
      setRGBColorFillF(r, g, b)
      rectangle(x, y, w, h)
      fillStroke()
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
    ].each {cya, mag, yel, black, x, y, w, h ->
      setColorFill(new CMYKColor(cya, mag, yel, black))
      rectangle(x, y, w, h)
      fillStroke()
    }
    [
      [0x00, 0x00, 0x00, 0x00,  36, 500, 36, 36],
      [0x00, 0xFF, 0xFF, 0x00,  90, 500, 36, 36],
      [0x00, 0xFF, 0xFF, 0x0F, 144, 500, 36, 36],
      [0xFF, 0xFF, 0x00, 0x00, 198, 500, 36, 36]
    ].each {cya, mag, yel, black, x, y, w, h ->
      setCMYKColorFill(cya, mag, yel, black)
      rectangle(x, y, w, h)
      fillStroke()
    }
    [
      [1f, 1f, 0f, 0.5f, 252, 500, 36, 36],
      [1f, 0f, 1f, 0f  , 306, 500, 36, 36],
      [1f, 0f, 1f, 0.5f, 360, 500, 36, 36],
      [0f, 0f, 0f, 1f  , 416, 500, 36, 36]
    ].each {cya, mag, yel, black, x, y, w, h ->
      setCMYKColorFillF(cya, mag, yel, black)
      rectangle(x, y, w, h)
      fillStroke()
    }
  }
}
