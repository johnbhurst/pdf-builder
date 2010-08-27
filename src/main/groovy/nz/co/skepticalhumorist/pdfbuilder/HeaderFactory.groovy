package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Header

class HeaderFactory extends ElementFactory {

  HeaderFactory() {
    elementClass = Header
    ctorArgTypes = [
      [name: String, content: String]
    ]
  }

}
