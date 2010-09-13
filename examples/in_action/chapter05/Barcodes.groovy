@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Element
import com.lowagie.text.Image
import com.lowagie.text.pdf.Barcode
import com.lowagie.text.pdf.Barcode128
import com.lowagie.text.pdf.Barcode39
import com.lowagie.text.pdf.BarcodeEAN
import com.lowagie.text.pdf.BarcodeEANSUPP
import com.lowagie.text.pdf.BarcodeCodabar
import com.lowagie.text.pdf.BarcodeInter25
import com.lowagie.text.pdf.BarcodePDF417
import com.lowagie.text.pdf.BarcodePostnet
import com.lowagie.text.pdf.PdfContentByte

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/Barcodes.pdf")).document() {
  PdfContentByte cb = writer.directContent

  paragraph("Barcode EAN.UCC-13")

  // EAN 13
  BarcodeEAN codeEAN = new BarcodeEAN()
  codeEAN.code = "4512345678906"
  paragraph(string: "default: ", leading: codeEAN.barcodeSize.height) {
    chunk(image: codeEAN.createImageWithBarcode(cb, null, null), offsetX: 0, offsetY: -5)
    codeEAN.guardBars = false
    chunk(" without guard bars: ")
    chunk(image: codeEAN.createImageWithBarcode(cb, null, null), offsetX: 0, offsetY: -5)
    codeEAN.baseline = -1
    codeEAN.guardBars = true
    chunk(" text above: ")
    chunk(image: codeEAN.createImageWithBarcode(cb, null, null), offsetX: 0, offsetY: -5)
  }

  codeEAN.setBaseline(codeEAN.size)
  // UPC A
  paragraph("Barcode UCC-12 (UPC-A)")
  codeEAN.codeType = Barcode.UPCA
  codeEAN.code = "785342304749"
  document.add(codeEAN.createImageWithBarcode(cb, null, null))

  // EAN 8
  paragraph("Barcode EAN.UCC-8")
  codeEAN.codeType = Barcode.EAN8
  codeEAN.barHeight = codeEAN.size * 1.5
  codeEAN.code = "34569870"
  document.add(codeEAN.createImageWithBarcode(cb, null, null))

  // UPC E
  paragraph("Barcode UPC-E")
  codeEAN.codeType = Barcode.UPCE
  codeEAN.code = "03456781"
  document.add(codeEAN.createImageWithBarcode(cb, null, null))
  codeEAN.barHeight = codeEAN.size * 3

  // EANSUPP
  paragraph("Bookland")
  paragraph("ISBN 0-321-30474-8")
  codeEAN.codeType = Barcode.EAN13
  codeEAN.code = "9780321304742"
  BarcodeEAN codeSUPP = new BarcodeEAN()
  codeSUPP.codeType = Barcode.SUPP5
  codeSUPP.code = "55499"
  codeSUPP.baseline = -2
  BarcodeEANSUPP eanSupp = new BarcodeEANSUPP(codeEAN, codeSUPP)
  document.add(eanSupp.createImageWithBarcode(cb, null, Color.blue))

  // CODE 128
  paragraph("Barcode 128")
  Barcode128 code128 = new Barcode128()
  code128.code = "0123456789 hello"
  document.add(code128.createImageWithBarcode(cb, null, null))
  char c = 0xffff as char
  code128.code = "0123456789" + c + "My Raw Barcode (0 - 9)"
  code128.codeType = Barcode.CODE128_RAW
  document.add(code128.createImageWithBarcode(cb, null, null))

  // Data for the barcode :
  String code402 = "24132399420058289"
  String code90 = "3700000050"
  String code421 = "422356"
  StringBuffer data = new StringBuffer(code402)
  data.append(Barcode128.FNC1)
  data.append(code90)
  data.append(Barcode128.FNC1)
  data.append(code421)
  Barcode128 shipBarCode = new Barcode128()
  shipBarCode.x = 0.75
  shipBarCode.n = 1.5
  shipBarCode.size = 10
  shipBarCode.textAlignment = Element.ALIGN_CENTER
  shipBarCode.baseline = 10
  shipBarCode.barHeight = 50
  shipBarCode.code = data.toString()
  document.add(shipBarCode.createImageWithBarcode(cb, Color.black, Color.blue))

  // it is composed of 3 blocks whith AI 01, 3101 and 10
  Barcode128 uccEan128 = new Barcode128()
  uccEan128.codeType = Barcode.CODE128_UCC
  uccEan128.code = "(01)00000090311314(10)ABC123(15)060916"
  document.add(uccEan128.createImageWithBarcode(cb, Color.blue, Color.black))
  uccEan128.code = "0191234567890121310100035510ABC123"
  document.add(uccEan128.createImageWithBarcode(cb, Color.blue, Color.red))
  uccEan128.code = "(01)28880123456788"
  document.add(uccEan128.createImageWithBarcode(cb, Color.blue, Color.black))

  // INTER25
  paragraph("Barcode Interleaved 2 of 5")
  BarcodeInter25 code25 = new BarcodeInter25()
  code25.generateChecksum = true
  code25.code = "41-1200076041-001"
  document.add(code25.createImageWithBarcode(cb, null, null))
  code25.code = "411200076041001"
  document.add(code25.createImageWithBarcode(cb, null, null))
  code25.code = "0611012345678"
  code25.checksumText = true
  document.add(code25.createImageWithBarcode(cb, null, null))
  document.newPage()

  // POSTNET
  paragraph("Barcode Postnet")
  BarcodePostnet codePost = new BarcodePostnet()
  paragraph("ZIP")
  codePost.code = "01234"
  document.add(codePost.createImageWithBarcode(cb, null, null))
  paragraph("ZIP+4")
  codePost.code = "012345678"
  document.add(codePost.createImageWithBarcode(cb, null, null))
  paragraph("ZIP+4 and dp")
  codePost.code = "01234567890"
  document.add(codePost.createImageWithBarcode(cb, null, null))

  paragraph("Barcode Planet")
  BarcodePostnet codePlanet = new BarcodePostnet()
  codePlanet.code = "01234567890"
  codePlanet.codeType = Barcode.PLANET
  document.add(codePlanet.createImageWithBarcode(cb, null, null))

  // CODE 39
  paragraph("Barcode 3 of 9")
  Barcode39 code39 = new Barcode39()
  code39.code = "ITEXT IN ACTION"
  document.add(code39.createImageWithBarcode(cb, null, null))

  paragraph("Barcode 3 of 9 extended")
  Barcode39 code39ext = new Barcode39()
  code39ext.code = "iText in Action"
  code39ext.startStopText = false
  code39ext.extended = true
  document.add(code39ext.createImageWithBarcode(cb, null, null))

  // CODABAR
  paragraph("Codabar")
  BarcodeCodabar codabar = new BarcodeCodabar()
  codabar.code = "A123A"
  codabar.startStopText = true
  document.add(codabar.createImageWithBarcode(cb, null, null))

  // PDF417
  paragraph("Barcode PDF417")
  BarcodePDF417 pdf417 = new BarcodePDF417()
  String text = "It was the best of times, it was the worst of times, " +
    "it was the age of wisdom, it was the age of foolishness, " +
    "it was the epoch of belief, it was the epoch of incredulity, " +
    "it was the season of Light, it was the season of Darkness, " +
    "it was the spring of hope, it was the winter of despair, " +
    "we had everything before us, we had nothing before us, " +
    "we were all going direct to Heaven, we were all going direct " +
    "the other way - in short, the period was so far like the present " +
    "period, that some of its noisiest authorities insisted on its " +
    "being received, for good or for evil, in the superlative degree " +
    "of comparison only."
  pdf417.setText(text)
  Image img = pdf417.getImage()
  img.scalePercent(50, 50 * pdf417.YHeight as float)
  document.add(img)
}
