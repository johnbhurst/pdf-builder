@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Phrase

def RESULT= "build/examples/in_action/chapter04/FoxDogChapter2.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  Phrase text = new Phrase("Quick brown fox jumps over the lazy dog. ")
  chapterAutoNumber("This is a sample sentence:", bookmarkTitle: "The fox", bookmarkOpen: false) {
    section("Quick") {
      3.times {current.add(text)}
    }
    section("Fox") {
      3.times {current.add(text)}
    }
  }
  chapterAutoNumber("Jumps") {
    section("Over") {
      3.times {current.add(text)}
      section("Lazy", indentationLeft: 30) {
        5.times {current.add(text)}
      }
      section("Dog", indentationRight: 30) {
        5.times {current.add(text)}
      }
      section("Did you see it?", indentation: 50) {
        5.times {current.add(text)}
      }
    }
  }
}
