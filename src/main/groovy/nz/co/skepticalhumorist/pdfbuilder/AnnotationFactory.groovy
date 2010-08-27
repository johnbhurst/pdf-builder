package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Annotation

class AnnotationFactory extends ElementFactory {
  AnnotationFactory() {
    elementClass = Annotation
    ctorArgTypes = [
      [llx: float, lly: float, urx: float, ury: float, application: String, parameters: String, operation: String, defaultdir: String],
      [llx: float, lly: float, urx: float, ury: float, moviePath: String, mimeType: String, showOnDisplay: boolean],
      [llx: float, lly: float, urx: float, ury: float, file: String, dest: String],
      [llx: float, lly: float, urx: float, ury: float, file: String, page: int],
      [llx: float, lly: float, urx: float, ury: float, url: String],
      [llx: float, lly: float, urx: float, ury: float, url: URL],
      [llx: float, lly: float, urx: float, ury: float, named: int],
      [title: String, text: String, llx: float, lly: float, urx: float, ury: float],
      [title: String, text: String],
      [annotation: Annotation]
    ]
  }
}
