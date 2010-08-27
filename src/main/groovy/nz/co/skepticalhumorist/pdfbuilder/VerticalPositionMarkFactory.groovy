package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.draw.DrawInterface
import com.lowagie.text.pdf.draw.VerticalPositionMark

class VerticalPositionMarkFactory extends ElementFactory {

  VerticalPositionMarkFactory() {
    elementClass = VerticalPositionMark
    ctorArgTypes = [
      [drawInterface: DrawInterface, offset: float]
    ]
  }

}
