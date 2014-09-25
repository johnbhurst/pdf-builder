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

import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Image
import com.lowagie.text.pdf.draw.DrawInterface

class ChunkFactory extends ElementFactory {

  ChunkFactory() {
    elementClass = Chunk
    ctorArgTypes = [
      [chunk: Chunk],
      [content: String, font: Font],
      [content: String],
      [c: char, font: Font],
      [c: char],
      [image: Image, offsetX: float, offsetY: float, changeLeading: boolean],
      [image: Image, offsetX: float, offsetY: float],
      [separator: DrawInterface, tabPosition: float, newline: boolean],
      [separator: DrawInterface, tabPosition: float],
      [separator: DrawInterface, vertical: boolean],
      [separator: DrawInterface],
    ]
  }

}
