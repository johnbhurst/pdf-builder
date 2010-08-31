package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test
import com.lowagie.text.Paragraph
import com.lowagie.text.Element

class TableTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document() {
      table(3, spacingBefore: 15, spacingAfter: 30) {
        cell(colspan: 3) {paragraph(string: "Table Heading", alignment: Element.ALIGN_CENTER)}
        cell(new Paragraph("cell 1,1")); cell(new Paragraph("cell 1,2")); cell(new Paragraph("cell 1,3"))
        cell(new Paragraph("cell 2,1")); cell(new Paragraph("cell 2,2")); cell(new Paragraph("cell 2,3"))
      }
    }
  }

}
