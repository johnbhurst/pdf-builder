package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.pdf.MultiColumnText

class MultiColumnTextFactory extends ElementFactory {

  MultiColumnTextFactory() {
    elementClass = MultiColumnText
    ctorArgTypes = [
      [top: float, height: float],
      [height: float]
    ]
  }

}
