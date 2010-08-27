package nz.co.skepticalhumorist.pdfbuilder

import de.oio.jpdfunit.document.util.TextSearchType
import org.junit.Test

class AnchorTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document() {
      paragraph {
        anchor("Quick brown fox jumps over the lazy dog.", reference: "http://en.wikipedia.org/wiki/The_quick_brown_fox_jumps_over_the_lazy_dog")
      }
      paragraph() {
        chunk("Quick brown ")
        anchor("fox", reference: "#fox")
        chunk(" jumps over the lazy dog.")
      }
      document.newPage()
      anchor("This is the FOX.", name: "fox")
    }
    defaultTester.assertContentContainsTextMultipleTimes("Quick brown", TextSearchType.CONTAINS)
  }

}
