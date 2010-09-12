@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk

def RESULT= "build/examples/in_action/chapter04/FoxDogScale.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  Chunk c = new Chunk("quick brown fox jumps over the lazy dog")
  float w = c.widthPoint
  paragraph("The width of the chunk: '") {
    current.add(c)
    chunk("' is $w points or ${w/72f as float} inches or ${w/72f*2.54f as float} cm.")
  }
  current.add(c)
  chunk(Chunk.NEWLINE)
  c.horizontalScaling = 0.5f
  current.add(c)
  current.add(c)
}
