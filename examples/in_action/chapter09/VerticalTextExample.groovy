@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.Chunk
import com.lowagie.text.Element
import com.lowagie.text.Font
import com.lowagie.text.PageSize
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.BaseFont
import com.lowagie.text.pdf.VerticalText

static String convertCIDs(String text) {
  char SPACE = ' ' as char
  char[] cid = text.toCharArray()
  for (k in 0..<cid.length) {
    char c = cid[k]
    if (c == '\n') {
      cid[k] = '\uff00' as char
    }
    else {
      cid[k] = c - SPACE + 8720 as char
    }
  }
  return new String(cid)
}


String movie = "\u4e03\u4eba\u306e\u4f8d";
String quote_p1 = "You embarrass me. You're overestimating me. Listen, I'm not a man with any special skill, but I've had plenty of experience in battles; losing battles, all of them.";
String quote_p2 = "In short, that's all I am. Drop such an idea for your own good.";

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter09/VerticalTextExample.pdf")).document() {
  BaseFont bf
  Font font
  bf = BaseFont.createFont("KozMinPro-Regular", "UniJIS-UCS2-V", BaseFont.NOT_EMBEDDED)
  font = new Font(bf, 20)
  new VerticalText(writer.directContent).with {
    setVerticalLayout(PageSize.A4.width * 0.75 as float, PageSize.A4.height - 36 as float, PageSize.A4.height - 72 as float, 8, 30)
    addText(new Chunk(movie, font))
    go()
    addText(new Phrase(quote_p1, font))
    go()
    setAlignment(Element.ALIGN_RIGHT)
    addText(new Phrase(quote_p2, font))
    go()
  }
  bf = BaseFont.createFont("KozMinPro-Regular", "Identity-V", BaseFont.NOT_EMBEDDED)
  font = new Font(bf, 20)
  new VerticalText(writer.directContent).with {
    setVerticalLayout(PageSize.A4.width * 0.25 as float, PageSize.A4.height - 36 as float, PageSize.A4.height - 72 as float, 8, 30)
    addText(new Phrase(convertCIDs(quote_p1), font))
    go()
    setAlignment(Element.ALIGN_RIGHT)
    addText(new Phrase(convertCIDs(quote_p2), font))
    go()
  }
}
