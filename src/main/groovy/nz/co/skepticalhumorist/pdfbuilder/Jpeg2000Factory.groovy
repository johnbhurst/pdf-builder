package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Jpeg2000

class Jpeg2000Factory extends ElementFactory {
  Jpeg2000Factory() {
    elementClass = Jpeg2000
    ctorArgTypes = [
      [img: byte[], width: float, height: float],
      [img: byte[]],
      [url: URL]
    ]
  }

}
