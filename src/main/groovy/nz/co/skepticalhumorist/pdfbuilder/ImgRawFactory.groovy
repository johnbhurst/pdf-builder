package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ImgRaw

class ImgRawFactory extends ElementFactory {
  ImgRawFactory() {
    elementClass = ImgRaw
    ctorArgTypes = [
      [width: int, height: int, components: int, bpc: int, data: byte[]]
    ]
  }

}
