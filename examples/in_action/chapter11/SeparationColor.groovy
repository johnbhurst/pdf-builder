@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.pdf.CMYKColor
import com.lowagie.text.pdf.GrayColor
import com.lowagie.text.pdf.SpotColor
import com.lowagie.text.pdf.PdfSpotColor

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter11/SeparationColor.pdf")).document() {
  PdfSpotColor psc_g = new PdfSpotColor("iTextSpotColorGray", 0.5f, new GrayColor(0.9f))
  PdfSpotColor psc_rgb = new PdfSpotColor("iTextSpotColorRGB", 0.9f, new Color(0x64, 0x95, 0xed))
  PdfSpotColor psc_cmyk = new PdfSpotColor("iTextSpotColorCMYK", 0.25f, new CMYKColor(0.3f, 0.9f, 0.3f, 0.1f))

  SpotColor sc_g = new SpotColor(psc_g, 0.5f)
  SpotColor sc_rgb1 = new SpotColor(psc_rgb, 0.1f)
  SpotColor sc_rgb2 = new SpotColor(psc_rgb, 0.2f)
  SpotColor sc_rgb3 = new SpotColor(psc_rgb, 0.3f)
  SpotColor sc_rgb4 = new SpotColor(psc_rgb, 0.4f)
  SpotColor sc_rgb5 = new SpotColor(psc_rgb, 0.5f)
  SpotColor sc_rgb6 = new SpotColor(psc_rgb, 0.6f)
  SpotColor sc_rgb7 = new SpotColor(psc_rgb, 0.7f)
  SpotColor sc_rgb8 = new SpotColor(psc_rgb, 0.8f)
  SpotColor sc_rgb9 = new SpotColor(psc_rgb, 0.9f)
  SpotColor sc_cmyk = new SpotColor(psc_cmyk, 0.25f)

  writer.directContent.with {
    setColorFill(sc_g)
    rectangle(36, 770, 36, 36)
    fillStroke()
    [
      [psc_g, 0.5f,  90, 770, 36, 36],
      [psc_g, 0.2f, 144, 770, 36, 36],
      [psc_g, 0.5f, 198, 770, 36, 36],
      [psc_g, 1   , 252, 770, 36, 36]
    ].each {c, t, x, y, w, h ->
      setColorFill(c, t)
      rectangle(x, y, w, h)
      fillStroke()
    }
    [
      [sc_rgb1,  36, 716, 36, 36],
      [sc_rgb2,  90, 716, 36, 36],
      [sc_rgb3, 144, 716, 36, 36],
      [sc_rgb4, 198, 716, 36, 36],
      [sc_rgb5, 252, 716, 36, 36],
      [sc_rgb6, 306, 716, 36, 36],
      [sc_rgb7, 360, 716, 36, 36],
      [sc_rgb8, 416, 716, 36, 36],
      [sc_rgb9, 470, 716, 36, 36]
    ].each {c, x, y, w, h ->
      setColorFill(c)
      rectangle(x, y, w, h)
      fillStroke()
    }
    [
      [psc_rgb, 0.1f,  36, 662, 36, 36],
      [psc_rgb, 0.2f,  90, 662, 36, 36],
      [psc_rgb, 0.3f, 144, 662, 36, 36],
      [psc_rgb, 0.4f, 198, 662, 36, 36],
      [psc_rgb, 0.5f, 252, 662, 36, 36],
      [psc_rgb, 0.6f, 306, 662, 36, 36],
      [psc_rgb, 0.7f, 360, 662, 36, 36],
      [psc_rgb, 0.8f, 416, 662, 36, 36],
      [psc_rgb, 0.9f, 470, 662, 36, 36]
    ].each {c, t, x, y, w, h ->
      setColorFill(c, t)
      rectangle(x, y, w, h)
      fillStroke()
    }
    setColorFill(sc_cmyk);
    rectangle(36, 608, 36, 36);
    fillStroke()
    setColorFill(psc_cmyk, 0.25f);
    rectangle(90, 608, 36, 36);
    fillStroke()
  }
}
