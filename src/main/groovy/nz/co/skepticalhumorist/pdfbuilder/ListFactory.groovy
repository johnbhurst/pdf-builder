package nz.co.skepticalhumorist.pdfbuilder

class ListFactory extends ElementFactory {

  ListFactory() {
    elementClass = com.lowagie.text.List
    ctorArgTypes = [
      [numbered: boolean, lettered: boolean, symbolIndent: float],
      [numbered: boolean, lettered: boolean],
      [numbered: boolean, symbolIndent: float],
      [numbered: boolean],
      [symbolIndent: float]
    ]
  }

}
