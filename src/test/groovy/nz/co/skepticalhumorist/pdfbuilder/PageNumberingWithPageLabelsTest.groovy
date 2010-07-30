package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.itextpdf.text.pdf.PdfPageLabels

class PageNumberingWithPageLabelsTest {
  @Test
  void testOk() {
    new PDFBuilder(outputStream: new File("PageNumberingWithPageLabelsTest.pdf").newOutputStream()).document(
      initWriter: {
        PdfPageLabels labels = new PdfPageLabels()
        labels.addPageLabel(1, PdfPageLabels.DECIMAL_ARABIC_NUMERALS)
        setPageLabels(labels)
      }
    ) {
      100.times {i ->
        paragraph("Paragraph $i.")
      }
    }
  }
}
