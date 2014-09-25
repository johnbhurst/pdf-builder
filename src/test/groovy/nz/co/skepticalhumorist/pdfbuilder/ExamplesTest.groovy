// Copyright 2014- John Hurst
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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
    runExamples("examples/in_action/chapter09")
    runExamples("examples/in_action/chapter10")
    runExamples("examples/in_action/chapter11")
    if (System.properties.containsKey("itext.examples.home")) {
      //println "Running iText examples..."
      runExamples("examples/in_action/chapter05")
      runExamples("examples/in_action/chapter06")
      runExamples("examples/in_action/chapter07")
      runExamples("examples/in_action/chapter08")
    }
  }
}
