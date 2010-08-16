package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test

class ExamplesTest {

  private void runExamples(String path) {
    new File("build/$path").mkdirs()
    def gse = new GroovyScriptEngine([path] as String[])
    new File(path).eachFileMatch(~/^.*\.groovy$/) {File file ->
      gse.run(file.name, new Binding())
    }
  }

  @Test
  void testOk() {
    runExamples("build/examples/classroom/intro")
  }
}