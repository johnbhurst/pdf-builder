@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.GrayColor
import java.awt.Color
import com.lowagie.text.Rectangle

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/ConstructingPaths4.pdf")).document() {
  writer.directContent.with {
    setColorStroke(new GrayColor(0.2f))
    setColorFill(new GrayColor(0.9f))
    circle(70, 770, 40)
    ellipse(120, 730, 240, 810)
    arc(250, 730, 370, 810, 45, 270)
    roundRectangle(30, 620, 80, 100, 20)
    fillStroke()
    Rectangle rect
    rect = new Rectangle(120, 620, 240, 720)
    rect.setBorder(Rectangle.BOX)
    rect.setBorderWidth(5)
    rect.setBorderColor(new GrayColor(0.2f))
    rect.setBackgroundColor(new GrayColor(0.9f))
    rectangle(rect)
    rect = new Rectangle(250, 620, 370, 720)
    rect.setBorder(Rectangle.BOX)
    rect.setBorderWidthTop(15)
    rect.setBorderWidthBottom(1)
    rect.setBorderWidthLeft(5)
    rect.setBorderWidthRight(10)
    rect.setBorderColorTop(new GrayColor(0.2f))
    rect.setBorderColorBottom(new Color(0xFF, 0x00, 0x00))
    rect.setBorderColorLeft(new Color(0xFF, 0xFF, 0x00))
    rect.setBorderColorRight(new Color(0x00, 0x00, 0xFF))
    rect.setBackgroundColor(new GrayColor(0.9f))
    rectangle(rect)
    variableRectangle(rect)
  }
}
