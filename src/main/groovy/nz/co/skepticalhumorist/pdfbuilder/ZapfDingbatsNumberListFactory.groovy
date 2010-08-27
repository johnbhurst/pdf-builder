package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ZapfDingbatsNumberList

class ZapfDingbatsNumberListFactory extends ElementFactory {

  ZapfDingbatsNumberListFactory() {
    elementClass = ZapfDingbatsNumberList
    ctorArgTypes = [
      [type: int, symbolIndent: int],
      [type: int]
    ]
  }

}
