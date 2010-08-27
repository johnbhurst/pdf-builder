package nz.co.skepticalhumorist.pdfbuilder

import java.awt.Color
import com.lowagie.text.Image
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfTemplate
import com.lowagie.text.pdf.PdfWriter
import com.lowagie.text.pdf.PRIndirectReference
import org.codehaus.groovy.runtime.InvokerHelper

class ImageFactory extends ElementFactory {

  ImageFactory() {
    elementClass = Image
    ctorArgTypes = [
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
  }

  @Override def createInstance(Object ctorArgs) {
    InvokerHelper.invokeStaticMethod(Image, "getInstance", ctorArgs)
  }

}
