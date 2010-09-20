@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter10/GraphicsStateStack.pdf")).document() {
  writer.directContent.withState {cb1 ->
    cb1.circle(260, 500, 250)
    cb1.fill()
    cb1.withState {cb2 ->
      cb2.setColorFill(Color.yellow)
      cb2.circle(260, 500, 200)
      cb2.fill()
      cb2.withState {cb3 ->
        cb3.setColorFill(Color.red)
        cb3.circle(260, 500, 150)
        cb3.fill()
      }
      cb2.circle(260, 500, 100)
      cb2.fill()
    }
    cb1.circle(260, 500, 50)
    cb1.fill()
  }
}
