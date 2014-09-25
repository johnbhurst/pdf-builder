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

import com.lowagie.text.List
import com.lowagie.text.ListItem
import com.lowagie.text.Chunk
import com.lowagie.text.Font
import com.lowagie.text.Phrase

class ListItemFactory extends ElementFactory {

  ListItemFactory() {
    elementClass = ListItem
    ctorArgTypes = [
      [leading: float, string: String, font: Font],
      [leading: float, string: String],
      [leading: float, chunk: Chunk],
      [leading: float],
      [string: String, font: Font],
      [string: String],
      [chunk: Chunk],
      [phrase: Phrase]
    ]
  }

  @Override
  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    // If called with a List, this does not match any ListItem constructor.
    // Instead we make a special case of this.
    // We return the List for List.add(List), and ignore any other attributes.
    // No ListItem is actually created.
    // Nested content is invalid.
    if (value instanceof List) {
      return value
    }
    else {
      return super.newInstance(builder, name, value, attributes)
    }
  }


}
