package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ZapfDingbatsList

class ZapfDingbatsListFactory extends ElementFactory {

  ZapfDingbatsListFactory() {
    elementClass = ZapfDingbatsList
    ctorArgTypes = [
      [zn: int, symbolIndent: int],
      [zn: int]
    ]
  }

}
