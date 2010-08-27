package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ImgJBIG2

class ImgJBIG2Factory extends ElementFactory {
  ImgJBIG2Factory() {
    elementClass = ImgJBIG2
    ctorArgTypes = [
      [width: int, height: int, data: byte[], globals: byte[]]
    ]
  }

}
