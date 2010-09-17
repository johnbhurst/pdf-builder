@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.pdf.Type3Font

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter08/Type3Characters.pdf")).document() {
  Type3Font t3 = new Type3Font(writer, [' ', '1', '2', '3', '4', '5'] as char[], false)
  t3.defineGlyph(' ' as char, 300, 0, 0, 600, 1200)
  t3.defineGlyph('1' as char, 600, 0, 0, 600, 1200).with {
    moveTo(250, 1200)
    lineTo(350, 100)
    lineTo(400, 1100)
    closePathFillStroke()
  }
  t3.defineGlyph('2' as char, 800, 0, 0, 800, 1200).with {
    moveTo(250, 1200)
    lineTo(350, 100)
    lineTo(400, 1100)
    closePathFillStroke()
    moveTo(450, 1200)
    lineTo(550, 100)
    lineTo(600, 1100)
    closePathFillStroke()
  }
  t3.defineGlyph('3' as char, 1000, 0, 0, 500, 600).with {
    moveTo(250, 1200)
    lineTo(350, 100)
    lineTo(400, 1100)
    closePathFillStroke()
    moveTo(450, 1200)
    lineTo(550, 100)
    lineTo(600, 1100)
    closePathFillStroke()
    moveTo(650, 1200)
    lineTo(750, 100)
    lineTo(800, 1100)
    closePathFillStroke()
  }
  t3.defineGlyph('4' as char, 1200, 0, 0, 600, 600).with {
    moveTo(250, 1200)
    lineTo(350, 100)
    lineTo(400, 1100)
    closePathFillStroke()
    moveTo(450, 1200)
    lineTo(550, 100)
    lineTo(600, 1100)
    closePathFillStroke()
    moveTo(650, 1200)
    lineTo(750, 100)
    lineTo(800, 1100)
    closePathFillStroke()
    moveTo(850, 1200)
    lineTo(950, 100)
    lineTo(1000, 1100)
    closePathFillStroke()
    closePathFillStroke()
  }
  t3.defineGlyph('5' as char, 1200, 0, 0, 1200, 1200).with {
    moveTo(250, 1200)
    lineTo(350, 100)
    lineTo(400, 1100)
    closePathFillStroke()
    moveTo(450, 1200)
    lineTo(550, 100)
    lineTo(600, 1100)
    closePathFillStroke()
    moveTo(650, 1200)
    lineTo(750, 100)
    lineTo(800, 1100)
    closePathFillStroke()
    moveTo(850, 1200)
    lineTo(950, 100)
    lineTo(1000, 1100)
    closePathFillStroke()
    moveTo(1200, 600)
    lineTo(0, 650)
    lineTo(100, 550)
    closePathFillStroke()
  }
  Font font = new Font(t3, 24)
  paragraph(string: "1 2 3 4 5\n5 5 5 5 5 5 5 1", font: font)
}
