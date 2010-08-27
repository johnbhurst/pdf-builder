package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ImgWMF

class ImgWMFFactory extends ElementFactory {
  ImgWMFFactory() {
    elementClass = ImgWMF
    ctorArgTypes = [
      [url: URL],
      [filename: String],
      [img: byte[]]
    ]
  }

}
