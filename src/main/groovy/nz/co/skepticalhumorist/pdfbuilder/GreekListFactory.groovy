package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.GreekList

class GreekListFactory extends ElementFactory {

  GreekListFactory() {
    elementClass = GreekList
    ctorArgTypes = [
      [greeklower: boolean, symbolIndent: int],
      [symbolIndent: int]
    ]
  }

}
