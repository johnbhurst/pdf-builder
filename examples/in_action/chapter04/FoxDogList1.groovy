@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.List
import com.lowagie.text.Phrase

def RESULT= "build/examples/in_action/chapter04/FoxDogList1.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  Phrase phrase = new Phrase("Quick brown fox jumps over")
  document.add(phrase)
  def list1 = list(numbered: List.ORDERED, symbolIndent: 20) {
    listItem("the lazy dog")
    listItem("the lazy cat")
    listItem("the fence")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  def list2 = list(numbered: List.UNORDERED, symbolIndent: 10) {
    listItem("the lazy dog")
    listItem("the lazy cat")
    listItem("the fence")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  def list3 = list(numbered: List.ORDERED, lettered: List.ALPHABETICAL, symbolIndent: 20) {
    listItem("the lazy dog")
    listItem("the lazy cat")
    listItem("the fence")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  def list4 = list(numbered: List.UNORDERED, symbolIndent: 30, listSymbol: "----->", indentationLeft: 10) {
    listItem("the lazy dog")
    listItem("the lazy cat")
    listItem("the fence")
  }
  chunk(Chunk.NEWLINE)
  document.add(phrase)
  def list5 = list(numbered: List.ORDERED, symbolIndent: 20, first: 11) {
    listItem("the lazy dog")
    listItem("the lazy cat")
    listItem("the fence")
  }
  document.add(Chunk.NEWLINE)
  list(numbered: List.UNORDERED, symbolIndent: 10, listSymbol: new Chunk("*")) {
    listItem("Quick brown fox jumps over")
    listItem(list1)
    listItem("Quick brown fox jumps over")
    listItem(list3)
    listItem("Quick brown fox jumps over")
    listItem(list5)
  }
}
