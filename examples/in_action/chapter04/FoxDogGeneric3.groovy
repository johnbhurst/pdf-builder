@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.pdf.events.IndexEvents

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter04/FoxDogGeneric3.pdf")).document() {
  def index = new IndexEvents()
  writer.setPageEvent(index)
  def create0 = {
    paragraph("Quick brown fox ") {
      current.add(index.create("jumps", "Jump"))
      chunk(" over the lazy dog.")
    }
  }
  def create1 = {
    paragraph() {
      current.add(index.create("Quick brown fox", "Fox", "quick, brown"))
      chunk(" jumps over ")
      current.add(index.create("the lazy dog.", "Dog", "lazy"))
      current.add(index.create(" ", "Jumping"))
    }
  }
  def create2 = {
    paragraph() {
      chunk("The fox is ")
      current.add(index.create("brown", "Color", "brown"))
      current.add(index.create(" ", "Brown", "color", "see Color; brown"))
      chunk(Chunk.NEWLINE)
    }
  }
  def create3 = {
    paragraph() {
      chunk("The dog is ")
      current.add(index.create("yellow", "Color", "yellow"))
      current.add(index.create(" ", "Yellow", "color", "see Color; yellow"))
      chunk(Chunk.NEWLINE)
    }
  }

  create0()
  create1()
  document.newPage()
  create1()
  document.newPage()
  create2()
  document.newPage()
  create3()
  document.newPage()
  create1()
  document.newPage()

  paragraph("Index:")
  index.sortedEntries.each {IndexEvents.Entry entry ->
    paragraph() {
      chunk(entry.in1)
      if (entry.in2.length()) {
        chunk("; ${entry.in2}")
      }
      if (entry.in3.length()) {
        chunk(" (${entry.in3})")
      }
      chunk(": ")
      for (i in 0..<entry.pagenumbers.size()) {
        chunk(" p${entry.pagenumbers[i]}", localGoto: entry.tags[i])
      }
    }
  }
}
