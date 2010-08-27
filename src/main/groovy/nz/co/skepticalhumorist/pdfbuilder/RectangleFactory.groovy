package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Rectangle

class RectangleFactory extends ElementFactory {

  RectangleFactory() {
    elementClass = Rectangle
    ctorArgTypes = [
      [llx: float, lly: float, urx: float, ury: float],
      [urx: float, ury: float],
      [rect: Rectangle]
    ]
  }

}
