package nz.co.skepticalhumorist.pdfbuilder

import org.junit.Test

class ExamplesTest {

  private void runExamples(String path) {
    new File("build/$path").mkdirs()
    def gse = new GroovyScriptEngine(["build/$path"] as String[])
    new File(path).eachFileMatch(~/^.*\.groovy$/) {File file ->
      gse.run(file.name, new Binding())
    }
  }

  @Test
  void testOk() {
    runExamples("examples/classroom/intro")
    runExamples("examples/questions/graphics2D")
    runExamples("examples/questions/separators")
    runExamples("examples/in_action/chapter04")
    if (System.properties.containsKey("itext.examples.home")) {
      //println "Running iText examples..."
      runExamples("examples/in_action/chapter05")
      runExamples("examples/in_action/chapter06")
      runExamples("examples/in_action/chapter07")
    }
  }
}
