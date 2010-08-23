package nz.co.skepticalhumorist.pdfbuilder

import com.lowagie.text.Chunk

class ChunkFactory extends AbstractFactory {

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    return new Chunk(value);
  }

}
