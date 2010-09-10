@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Font
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase

def RESULT= "build/examples/in_action/chapter04/FoxDogChapter1.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  Phrase text = new Phrase("Quick brown fox jumps over the lazy dog. ")
  Font font = new Font(Font.HELVETICA, 14, Font.BOLD)
  chapter(title: new Paragraph("This is the title.", font), number: 1) {
    current.add(text)
    section(title: "Quick", numberDepth: 0) {
      3.times {current.add(text)}
    }
    section(title: "Fox", numberDepth: 0) {
      3.times {current.add(text)}
    }
  }
  chapter(title: "Jumps", number: 2) {
    section(title: "Over", numberDepth: 1) {
      3.times {current.add(text)}
      section(title: "Lazy", numberDepth: 2, indentationLeft: 30) {
        5.times {current.add(text)}
      }
      section(title: "Dog", numberDepth: 2, indentationRight: 30) {
        5.times {current.add(text)}
      }
      section(title: "Did you see it?", numberDepth: 2, indentation: 50) {
        5.times {current.add(text)}
      }
    }
  }
}
