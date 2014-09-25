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

class PageEventTest extends AbstractPDFBuilderTestCase {

  @Test
  void testOk() {
    defaultBuilder.document(
      onChapter: {writer, document, paragraphPosition, title ->
        println("onChapter($writer, $document, $paragraphPosition, $title)")
      },
      onChapterEnd: {writer, document, paragraphPosition ->
        println("onChapterEnd($writer, $document, $paragraphPosition)")
      },
      onCloseDocument: {writer, document ->
        println("onCloseDocument($writer, $document)")
      },
      onEndPage: {writer, document ->
        println("onEndPage($writer, $document)")
      },
      onGenericTag: {writer, document, rect, text ->
        println("onGenericTag($writer, $document, $rect, $text)")
      },
      onOpenDocument: {writer, document ->
        println("onOpenDocument($writer, $document)")
      },
      onParagraph: {writer, document, paragraphPosition ->
        println("onParagraph($writer, $document, $paragraphPosition)")
      },
      onParagraphEnd: {writer, document, paragraphPosition ->
        println("onParagraphEnd($writer, $document, $paragraphPosition)")
      },
      onSection: {writer, document, paragraphPosition, depth, title ->
        println("onSection($writer, $document, $paragraphPosition, $depth, $title)")
      },
      onSectionEnd: {writer, document, paragraphPosition ->
        println("onSectionEnd($writer, $document, $paragraphPosition)")
      },
      onStartPage: {writer, document ->
        println("onStartPage($writer, $document)")
      }
    ) {
      paragraph("A very short document, with many events.")
    }
  }

}
