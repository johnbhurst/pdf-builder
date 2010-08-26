package nz.co.skepticalhumorist.pdfbuilder

import java.awt.Color
import com.lowagie.text.Image
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfTemplate
import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.pdf.PRIndirectReference
import org.codehaus.groovy.runtime.InvokerHelper

class ImageFactory extends AbstractElementFactory {

  def ctorArgTypes = [
    [image: Image, color: Color, forceBW: boolean],
    [image: Image, color: Color],
    [width: int, height: int, reverseBits: boolean, typeCCITT: int, parameters: int, data: byte[], transparency: int[]],
    [width: int, height: int, reverseBits: boolean, typeCCITT: int, parameters: int, data: byte[]],
    [width: int, height: int, data: byte[], globals: byte[]],
    [width: int, height: int, components: int, bpc: int, data: byte[], transparency: int[]],
    [width: int, height: int, components: int, bpc: int, data: byte[]],
    [cb: PdfContentByte, awtImage: java.awt.Image, quality: float],
    [writer: PdfWriter, awtImage: java.awt.Image, quality: float],
    [imgb: byte[]],
    [image: Image],
    [template: PdfTemplate],
    [ref: PRIndirectReference],
    [filename: String],
    [url: URL]
  ]

  Image newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    def ctorArgs = PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
    Image result = InvokerHelper.invokeStaticMethod(Image, "getInstance", ctorArgs)
    if (attributes.containsKey("init")) {
      Closure init = attributes.remove("init")
      init.delegate = result
      init()
    }
    attributes.each {key, val ->
      result[key] = val
    }
    return result
  }

}
