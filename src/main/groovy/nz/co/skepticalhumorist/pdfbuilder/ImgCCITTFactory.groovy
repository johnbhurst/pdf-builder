package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ImgCCITT

class ImgCCITTFactory extends ElementFactory {
  ImgCCITTFactory() {
    elementClass = ImgCCITT
    ctorArgTypes = [
      [width: int, height: int, reverseBits: boolean, typeCCITT: int, parameters: int, data: byte[]]
    ]
  }

}
