@Grab("nz.co.skepticalhumorist:pdf-builder:latest.release")
import nz.co.skepticalhumorist.pdfbuilder.PDFBuilder
import com.lowagie.text.pdf.RandomAccessFileOrArray
import com.lowagie.text.pdf.codec.TiffImage

String imageLocation(String imageName) {
  System.properties["itext.examples.home"] + "/resources/in_action/chapter05/" + imageName
}

new PDFBuilder(new FileOutputStream("build/examples/in_action/chapter05/MultipageTiff.pdf")).document() {
  paragraph("This is the tiff added with Image.getInstance:")
  image(imageLocation("foxdog_multiplepages.tif"))
  RandomAccessFileOrArray ra = new RandomAccessFileOrArray(imageLocation("foxdog_multiplepages.tif"))
  int pages = TiffImage.getNumberOfPages(ra)
  paragraph("There are $pages pages in the tiff file.")
  for (i in 1..pages) {
    current.add(TiffImage.getTiffImage(ra, i))
  }
}
