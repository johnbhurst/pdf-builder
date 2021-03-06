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

import com.lowagie.text.Annotation

class AnnotationFactory extends ElementFactory {
  AnnotationFactory() {
    elementClass = Annotation
    ctorArgTypes = [
      [llx: float, lly: float, urx: float, ury: float, application: String, parameters: String, operation: String, defaultdir: String],
      [llx: float, lly: float, urx: float, ury: float, moviePath: String, mimeType: String, showOnDisplay: boolean],
      [llx: float, lly: float, urx: float, ury: float, file: String, dest: String],
      [llx: float, lly: float, urx: float, ury: float, file: String, page: int],
      [llx: float, lly: float, urx: float, ury: float, url: String],
      [llx: float, lly: float, urx: float, ury: float, url: URL],
      [llx: float, lly: float, urx: float, ury: float, named: int],
      [title: String, text: String, llx: float, lly: float, urx: float, ury: float],
      [title: String, text: String],
      [annotation: Annotation]
    ]
  }
}
