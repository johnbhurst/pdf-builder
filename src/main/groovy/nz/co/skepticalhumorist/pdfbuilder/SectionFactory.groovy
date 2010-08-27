package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Section
import com.lowagie.text.Paragraph
import org.codehaus.groovy.runtime.InvokerHelper

class SectionFactory extends ElementFactory {

  SectionFactory() {
    elementClass = Section
    ctorArgTypes = [
      [indentation: float, title: Paragraph, numberDepth: int],
      [indentation: float, title: Paragraph],
      [title: Paragraph, numberDepth: int],
      [title: Paragraph],
      [indentation: float, title: String, numberDepth: int],
      [indentation: float, title: String],
      [title: String, numberDepth: int],
      [title: String]
    ]
  }

  /**
   * Creates a new Section node.
   * Sections are created by invoking addSection() on a Chapter or Section.
   * @param builder The builder.
   * @param ctorArgs The constructor (i.e. addSection()) arguments.
   * @return The new Section.
   */
  @Override def createInstance(FactoryBuilderSupport builder, Object ctorArgs) {
    InvokerHelper.invokeMethod(builder.current, "addSection", ctorArgs)
  }

}
