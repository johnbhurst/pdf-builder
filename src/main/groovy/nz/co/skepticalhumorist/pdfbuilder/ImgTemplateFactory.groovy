package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ImgTemplate
import com.lowagie.text.pdf.PdfTemplate

class ImgTemplateFactory extends ElementFactory {
  ImgTemplateFactory() {
    elementClass = ImgTemplate
    ctorArgTypes = [
      [template: PdfTemplate]
    ]
  }

}
