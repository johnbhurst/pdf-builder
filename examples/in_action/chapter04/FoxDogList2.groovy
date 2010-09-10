@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.Phrase

def RESULT= "build/examples/in_action/chapter04/FoxDogList2.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  Phrase phrase = new Phrase("Quick brown fox jumps over")
  document.add(phrase)
  romanList(20, lowercase: true) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  romanList(20, lowercase: false) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  greekList(20, lowercase: true) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  greekList(20, lowercase: false) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  zapfDingbatsList(zn: 42, symbolIndent: 15) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  zapfDingbatsNumberList(type: 0, symbolIndent: 15) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  zapfDingbatsNumberList(type: 1, symbolIndent: 15) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  zapfDingbatsNumberList(type: 2, symbolIndent: 15) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  zapfDingbatsNumberList(type: 3, symbolIndent: 15) {
    listItem("the lazy dog")
    listItem("the lazy cat")
  }
}
