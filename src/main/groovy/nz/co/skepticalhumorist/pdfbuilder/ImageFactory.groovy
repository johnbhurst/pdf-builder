package nz.co.skepticalhumorist.pdfbuilder

import java.awt.Color
import com.lowagie.text.Image
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.pdf.PdfTemplate
import com.lowagie.text.pdf.PRIndirectReference

class ImageFactory extends AbstractFactory {

  Image newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    Image result = null
    if (attributes.containsKey("image") && attributes.containsKey("color") && attributes.containsKey("forceBW")) {
      Image image = attributes.remove("image")
      Color color = attributes.remove("color")
      boolean forceBW = attributes.remove(("forceBW"))
      result = Image.getInstance(image, color, forceBW)
    }
    else if (attributes.containsKey("image") && attributes.containsKey("color")) {
      Image image = attributes.remove("image")
      Color color = attributes.remove("color")
      result = Image.getInstance(image, color)
    }
    else if (attributes.containsKey("width") && attributes.containsKey("height") &&
             attributes.containsKey("reverseBits") && attributes.containsKey("typeCCITT") &&
             attributes.containsKey("parameters") && attributes.containsKey("data") &&
             attributes.containsKey("transparency")) {
      int width = attributes.remove("width")
      int height = attributes.remove("height")
      boolean reverseBits = attributes.remove("reverseBits")
      int typeCCITT = attributes.remove("typeCCITT")
      int parameters = attributes.remove("parameters")
      byte[] data = attributes.remove("data")
      int[] transparency = attributes.remove("transparency")
      result = Image.getInstance(width, height, reverseBits, typeCCITT, parameters, data, transparency)
    }
    else if (attributes.containsKey("width") && attributes.containsKey("height") &&
             attributes.containsKey("reverseBits") && attributes.containsKey("typeCCITT") &&
             attributes.containsKey("parameters") && attributes.containsKey("data")) {
      int width = attributes.remove("width")
      int height = attributes.remove("height")
      boolean reverseBits = attributes.remove("reverseBits")
      int typeCCITT = attributes.remove("typeCCITT")
      int parameters = attributes.remove("parameters")
      byte[] data = attributes.remove("data")
      result = Image.getInstance(width, height, reverseBits, typeCCITT, parameters, data)
    }
    else if (attributes.containsKey("width") && attributes.containsKey("height") &&
             attributes.containsKey("data") && attributes.containsKey("globals")) {
      int width = attributes.remove("width")
      int height = attributes.remove("height")
      byte[] data = attributes.remove("data")
      byte[] globals = attributes.remove("globals")
      result = Image.getInstance(width, height, data, globals)
    }
    else if (attributes.containsKey("width") && attributes.containsKey("height") &&
             attributes.containsKey("components") && attributes.containsKey("bpc") &&
             attributes.containsKey("data") && attributes.containsKey("transparency")) {
      int width = attributes.remove("width")
      int height = attributes.remove("height")
      int components = attributes.remove("components")
      int bpc = attributes.remove("bpc")
      byte[] data = attributes.remove("data")
      int[] transparency = attributes.remove("transparency")
      result = Image.getInstance(width, height, components, bpc, data, transparency)
    }
    else if (attributes.containsKey("width") && attributes.containsKey("height") &&
             attributes.containsKey("components") && attributes.containsKey("bpc") &&
             attributes.containsKey("data")) {
      int width = attributes.remove("width")
      int height = attributes.remove("height")
      int components = attributes.remove("components")
      int bpc = attributes.remove("bpc")
      byte[] data = attributes.remove("data")
      result = Image.getInstance(width, height, components, bpc, data)
    }
    else if (attributes.containsKey("cb") && attributes.containsKey("awtImage") &&
             attributes.containsKey("quality")) {
      PdfContentByte cb = attributes.remove("cb")
      java.awt.Image awtImage = attributes.remove("awtImage")
      float quality = attributes.remove("quality")
      result = Image.getInstance(cb, awtImage, quality)
    }
    else if (attributes.containsKey("writer") && attributes.containsKey("awtImage") &&
            attributes.containsKey("quality")) {
      PdfWriter writer = attributes.remove("writer")
      java.awt.Image awtImage = attributes.remove("awtImage")
      float quality = attributes.remove("quality")
      result = Image.getInstance(writer, awtImage, quality)
    }
    else if (attributes.containsKey("imgb")) {
      byte[] imgb = attributes.remove("imgb")
      result = Image.getInstance(imgb)
    }
    else if (attributes.containsKey("image")) {
      Image image = attributes.remove("image")
      result = Image.getInstance(image)
    }
    else if (attributes.containsKey("template")) {
      PdfTemplate template = attributes.remove("template")
      result = Image.getInstance(template)
    }
    else if (attributes.containsKey("ref")) {
      PRIndirectReference ref = attributes.remove("ref")
      result = Image.getInstance(ref)
    }
    else if (attributes.containsKey("filename")) {
      String filename = attributes.remove("filename")
      result = Image.getInstance(filename)
    }
    else if (attributes.containsKey("url")) {
      URL url = attributes.remove("url")
      result = Image.getInstance(url)
    }
    else {
      result = Image.getInstance(value)
    }
    if (attributes.containsKey("init")) {
      Closure init = attributes.remove("init")
      init.delegate = result
      init()
    }
//    if (attributes.containsKey("percent")) {
//      float percent = attributes.remove("percent")
//      result.scalePercent(percent)
//    }
//    if (attributes.containsKey("percentX") && attributes.containsKey("percentY")) {
//      float percentX = attributes.remove("percentX")
//      float percentY = attributes.remove("percentY")
//      result.scalePercent(percentX, percentY)
//    }
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

}
