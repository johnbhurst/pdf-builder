package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Rectangle
import com.lowagie.text.RectangleReadOnly

class RectangleReadOnlyFactory extends ElementFactory {

  RectangleReadOnlyFactory() {
    elementClass = RectangleReadOnly
    ctorArgTypes = [
      [llx: float, lly: float, urx: float, ury: float],
      [urx: float, ury: float],
      [rect: Rectangle]
    ]
  }

}
