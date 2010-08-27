package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Meta

class MetaFactory extends ElementFactory {

  MetaFactory() {
    elementClass = Meta
    ctorArgTypes = [
      [tag: String, content: String]
    ]
  }

}
