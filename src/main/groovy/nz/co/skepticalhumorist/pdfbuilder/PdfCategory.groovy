package nz.co.skepticalhumorist.pdfbuilder

import java.awt.Graphics2D
import com.lowagie.text.pdf.FontMapper
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfTemplate
import com.lowagie.text.pdf.PdfWriter
import org.codehaus.groovy.runtime.DefaultGroovyMethods

class PdfCategory {
  static void withDirectContent(PdfWriter writer, Closure closure) {
    doWithContentByte(writer.directContent, closure)
  }

  static void withDirectContentUnder(PdfWriter writer, Closure closure) {
    doWithContentByte(writer.directContentUnder, closure)
  }

  private static void doWithContentByte(PdfContentByte cb, Closure closure) {
    cb.saveState()
    try {
      closure.call(cb)
    }
    finally {
      cb.restoreState()
    }
  }

  // createTemplate(width, height)
  // createTemplate(width, height, PdfName forcedName) (not public)
  // addTemplate(template, a, b, c, d, e, f)
  // addTemplate(template, x, y)
  // addTemplate(template, AffineTransform) (iText 5 only)

  static void addTemplate(PdfContentByte cb, float width, float height, float a, float b, float c, float d, float e, float f, Closure closure) {
    cb.addTemplate(createTemplate(cb, width, height, closure), a, b, c, d, e, f)
  }

  static void addTemplate(PdfContentByte cb, float width, float height, float x, float y, Closure closure) {
    cb.addTemplate(createTemplate(cb, width, height, closure), x, y)
  }

  private static createTemplate(PdfContentByte cb, float width, float height, Closure closure) {
    PdfTemplate template = cb.createTemplate(width, height)
    DefaultGroovyMethods.mixin(template.metaClass, PdfCategory)
    closure.call(template)
    template
  } 

  static void withGraphics(PdfContentByte cb, float width, float height, Closure closure) {
    doWithGraphics(cb, cb.createGraphics(width, height), closure)
  }

  static void withGraphics(PdfContentByte cb, float width, float height, FontMapper fontMapper, Closure closure) {
    doWithGraphics(cb, cb.createGraphics(width, height, fontMapper), closure)
  }

  static void withGraphics(PdfContentByte cb, float width, float height, boolean convertImagesToJPEG, float quality, Closure closure) {
    doWithGraphics(cb, cb.createGraphics(width, height, convertImagesToJPEG, quality), closure)
  }

  static void withGraphics(PdfContentByte cb, float width, float height, FontMapper fontMapper, boolean convertImagesToJPEG, float quality, Closure closure) {
    doWithGraphics(cb, cb.createGraphics(width, height, fontMapper, convertImagesToJPEG, quality), closure)
  }

  static void withGraphicsShapes(PdfContentByte cb, float width, float height, Closure closure) {
    doWithGraphics(cb, cb.createGraphicsShapes(width, height), closure)
  }

  static void withGraphicsShapes(PdfContentByte cb, float width, float height, boolean convertImagesToJPEG, float quality, Closure closure) {
    doWithGraphics(cb, cb.createGraphicsShapes(width, height, convertImagesToJPEG, quality), closure)
  }

  private static void doWithGraphics(PdfContentByte cb, Graphics2D graphics, Closure closure) {
    try {
      if (closure.maximumNumberOfParameters > 1) {
        closure.call(cb, graphics)
      }
      else {
        closure.call(graphics)
      }
    }
    finally {
      graphics.dispose()
    }
  }

  // tentative ... either this or perhaps withDirectContentWithText() ?
  static void withText(PdfContentByte cb, Closure closure) {
    cb.beginText()
    try {
      closure.call(cb)
    }
    finally {
      cb.endText()
    }
  }
}
