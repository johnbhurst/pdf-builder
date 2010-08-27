package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Chapter
import com.lowagie.text.Paragraph

class ChapterFactory extends ElementFactory {

  ChapterFactory() {
    elementClass = Chapter
    ctorArgTypes = [
      [title: Paragraph, number: int],
      [title: String, number: int],
      [number: int]
    ]
  }

}
