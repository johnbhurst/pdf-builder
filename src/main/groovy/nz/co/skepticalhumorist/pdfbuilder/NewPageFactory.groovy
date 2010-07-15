package nz.co.skepticalhumorist.pdfbuilder

class NewPageFactory extends AbstractFactory {

  DocumentCommand newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    return new NewPageCommand()
  }

}
