package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.ChapterAutoNumber
import com.lowagie.text.Paragraph

class ChapterAutoNumberFactory extends ElementFactory {

  ChapterAutoNumberFactory() {
    elementClass = ChapterAutoNumber
    ctorArgTypes = [
      [title: Paragraph],
      [title: String]
    ]
  }

}
