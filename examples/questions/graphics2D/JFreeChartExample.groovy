@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
@Grab("jfree:jfreechart:1.0.13")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Graphics2D
import java.awt.geom.Rectangle2D
import com.lowagie.text.pdf.DefaultFontMapper
import com.lowagie.text.pdf.PdfTemplate
import org.jfree.data.category.DefaultCategoryDataset
import org.jfree.data.general.DefaultPieDataset
import org.jfree.chart.ChartFactory
import org.jfree.chart.JFreeChart
import org.jfree.chart.plot.PlotOrientation

JFreeChart getBarChart() {
  DefaultCategoryDataset dataset = new DefaultCategoryDataset()
  dataset.setValue(57, "students", "Asia")
  dataset.setValue(36, "students", "Africa")
  dataset.setValue(29, "students", "S-America")
  dataset.setValue(17, "students", "N-America")
  dataset.setValue(12, "students", "Australia")
  ChartFactory.createBarChart(
    "T.U.F. Students",
    "continent",
    "number of students",
    dataset,
    PlotOrientation.VERTICAL,
    false,
    true,
    false
  )
}

JFreeChart getPieChart() {
  DefaultPieDataset dataset = new DefaultPieDataset()
  dataset.setValue("Europe", 302)
  dataset.setValue("Asia", 57)
  dataset.setValue("Africa", 17)
  dataset.setValue("S-America", 29)
  dataset.setValue("N-America", 17)
  dataset.setValue("Australia", 12)
  ChartFactory.createPieChart(
    "Students per continent",
    dataset,
    true,
    true,
    false
  )
}

def RESULT = "build/examples/questions/graphics2D/JFreeChartExample.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document() {
  def width = 400
  def height = 360
  Rectangle2D rect = new Rectangle2D.Double(0, 0, width, height)
  writer.directContent.with {
    addTemplate(width, height, 100, 440) {PdfTemplate template ->
      template.withGraphics(width, height, new DefaultFontMapper()) {Graphics2D graphics ->
        barChart.draw(graphics, rect);
      }
    }
    addTemplate(width, height, 100, 40) {PdfTemplate template ->
      template.withGraphics(width, height, new DefaultFontMapper()) {Graphics2D graphics ->
        pieChart.draw(graphics, rect)
      }
    }
  }
}
