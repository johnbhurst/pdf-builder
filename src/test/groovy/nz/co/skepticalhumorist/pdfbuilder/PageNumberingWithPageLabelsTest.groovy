package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.pdf.PdfPageLabels

class PageNumberingWithPageLabelsTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document(
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
