package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Element
import com.lowagie.text.Paragraph
import org.junit.Test

class TableAddCellTest extends AbstractPDFBuilderTestCase {
  @Test
  void testOk() {
    defaultBuilder.document() {
      table(3, spacingBefore: 15, spacingAfter: 30) {
        cell(colspan: 3) {paragraph(string: "Table Heading", alignment: Element.ALIGN_CENTER)}
        cell("cell 1,1"); cell("cell 1,2"); cell("cell 1,3")
        cell("cell 2,1"); cell("cell 2,2"); cell("cell 2,3")
      }
    }
  }

}
