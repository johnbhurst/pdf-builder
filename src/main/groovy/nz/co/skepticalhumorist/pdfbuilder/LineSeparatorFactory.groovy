package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.draw.LineSeparator
import java.awt.Color

class LineSeparatorFactory extends ElementFactory {

  LineSeparatorFactory() {
    elementClass = LineSeparator
    ctorArgTypes = [
      [lineWidth: float, percentage: float, lineColor: Color, align: int, offset: float]
    ]
  }

}
