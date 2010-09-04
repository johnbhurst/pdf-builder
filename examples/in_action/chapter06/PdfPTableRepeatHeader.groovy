@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import java.awt.Color
import com.lowagie.text.Element
import com.lowagie.text.Font
import com.lowagie.text.FontFactory
import com.lowagie.text.PageSize
import com.lowagie.text.Phrase
import com.lowagie.text.pdf.PdfPTable

def RESULT= "build/examples/in_action/chapter06/PdfPTableRepeatHeader.pdf"
new PDFBuilder(new FileOutputStream(RESULT)).document(PageSize.A4.rotate()) {
  table(10, widths: [10, 24, 12, 12, 7, 7, 7, 7, 7, 7] as int[], widthPercentage: 100, splitLate: false, headerRows: 2) {
    def datatable = current

    datatable.defaultCell.padding = 5

    // The header starts with a cell that spans 10 columns
    cell(new Phrase("Administration - System Users Report", FontFactory.getFont(FontFactory.HELVETICA, 24, Font.BOLD)), horizontalAlignment: Element.ALIGN_CENTER, borderWidth: 2, colspan: 10, backgroundColor: new Color(0xC0, 0xC0, 0xC0), useDescender: true)

    // We need 4 cells with rowspan 2
    datatable.defaultCell.borderWidth = 2
    datatable.defaultCell.horizontalAlignment = Element.ALIGN_CENTER
    datatable.addCell("User Id")
    datatable.addCell("Name\nAddress")
    datatable.addCell("Company")
    datatable.addCell("Department")

    // we use a nested table to fake this
    def permissions = new PdfPTable(6)
    permissions.defaultCell.borderWidth = 2
    permissions.defaultCell.horizontalAlignment = Element.ALIGN_CENTER
    permissions.defaultCell.colspan = 6
    permissions.addCell("Permissions")
    permissions.defaultCell.colspan = 1
    permissions.addCell("Admin")
    permissions.addCell("Data")
    permissions.addCell("Expl")
    permissions.addCell("Prod")
    permissions.addCell("Proj")
    permissions.addCell("Online")
    cell(permissions, colspan: 6)
    // this is the end of the table header

    // as far as PdfPTable is concerned there are 2 rows in the header

    // we add the data to the table
    datatable.defaultCell.borderWidth = 1
    for (i in 1..29) {
      datatable.defaultCell.horizontalAlignment = Element.ALIGN_LEFT
      datatable.addCell("myUserId")
      datatable.addCell("Somebody with a very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very, very long long name")
      datatable.addCell("No Name Company")
      datatable.addCell("D$i")
      datatable.defaultCell.horizontalAlignment = Element.ALIGN_CENTER
      for (j in 0..5) {
        datatable.addCell(Math.random() > 0.5 ? "Yes" : "No")
      }
    }
  }
}
