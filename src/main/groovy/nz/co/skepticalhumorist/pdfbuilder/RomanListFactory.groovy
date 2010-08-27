package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.RomanList

class RomanListFactory extends ElementFactory {

  RomanListFactory() {
    elementClass = RomanList
    ctorArgTypes = [
      [lowercase: boolean, symbolIndent: int],
      [symbolIndent: int]
    ]
  }

}
