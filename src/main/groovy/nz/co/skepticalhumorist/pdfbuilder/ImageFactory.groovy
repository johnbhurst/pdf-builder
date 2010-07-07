package nz.co.skepticalhumorist.pdfbuilder

import com.itextpdf.text.Image

class ImageFactory extends AbstractFactory {

  Image newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    if (attributes.containsKey("filename")) {
      String filename = attributes.remove("filename")
      return Image.getInstance(filename)
    }
    return null
  }

}
