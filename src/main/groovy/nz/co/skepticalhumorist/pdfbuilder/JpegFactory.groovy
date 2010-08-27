package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Jpeg

class JpegFactory extends ElementFactory {
  JpegFactory() {
    elementClass = Jpeg
    ctorArgTypes = [
      [img: byte[], width: float, height: float],
      [img: byte[]],
      [url: URL]
    ]
  }

}
