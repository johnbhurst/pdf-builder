package nz.co.skepticalhumorist.pdfbuilder

import java.awt.Graphics2D
import com.lowagie.text.pdf.FontMapper
import com.lowagie.text.pdf.PdfContentByte
import com.lowagie.text.pdf.PdfTemplate
import org.codehaus.groovy.runtime.DefaultGroovyMethods
import com.lowagie.text.pdf.PatternColor
import com.lowagie.text.pdf.PdfPatternPainter
import java.awt.Color

class PdfCategory {

  static void withState(PdfContentByte cb, Closure closure) {
    cb.saveState()
    try {
      closure.call(cb)
    }
    finally {
      cb.restoreState()
    }
  }

  static void withText(PdfContentByte cb, Closure closure) {
    cb.beginText()
    try {
      closure.call(cb)
    }
    finally {
      cb.endText()
    }
  }

  // createTemplate(width, height)
  // createTemplate(width, height, PdfName forcedName) (not public)
  // addTemplate(template, a, b, c, d, e, f)
  // addTemplate(template, x, y)
  // addTemplate(template, AffineTransform) (iText 5 only)

  static PdfTemplate addTemplate(PdfContentByte cb, float width, float height, float a, float b, float c, float d, float e, float f, Closure closure) {
    def template = createTemplate(cb, width, height, closure)
    cb.addTemplate(template, a, b, c, d, e, f)
    template
  }

  static PdfTemplate addTemplate(PdfContentByte cb, float width, float height, float x, float y, Closure closure) {
    def template = createTemplate(cb, width, height, closure)
    cb.addTemplate(template, x, y)
    template
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

  static PatternColor createPatternColor(PdfContentByte cb, float width, float height, Closure closure) {
    PdfPatternPainter painter = cb.createPattern(width, height)
    makePatternColor(painter, closure)
  }

  static PatternColor createPatternColor(PdfContentByte cb, float width, float height, Color color, Closure closure) {
    PdfPatternPainter painter = cb.createPattern(width, height, color)
    makePatternColor(painter, closure)
  }

  static PatternColor createPatternColor(PdfContentByte cb, float width, float height, float xstep, float ystep, Closure closure) {
    PdfPatternPainter painter = cb.createPattern(width, height, xstep, ystep)
    makePatternColor(painter, closure)
  }

  static PatternColor createPatternColor(PdfContentByte cb, float width, float height, float xstep, float ystep, Color color, Closure closure) {
    PdfPatternPainter painter = cb.createPattern(width, height, xstep, ystep, color)
    makePatternColor(painter, closure)
  }

  private static PatternColor makePatternColor(PdfPatternPainter painter, Closure closure) {
    DefaultGroovyMethods.mixin(painter.metaClass, PdfCategory)
    closure.call(painter)
    PatternColor result = new PatternColor(painter)
    DefaultGroovyMethods.mixin(result.metaClass, PdfCategory)
    result
  }

}
