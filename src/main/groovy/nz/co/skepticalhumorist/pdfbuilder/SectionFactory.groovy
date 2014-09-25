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

import com.lowagie.text.Section
import com.lowagie.text.Paragraph
import org.codehaus.groovy.runtime.InvokerHelper

class SectionFactory extends ElementFactory {

  SectionFactory() {
    elementClass = Section
    ctorArgTypes = [
      [indentation: float, title: Paragraph, numberDepth: int],
      [indentation: float, title: Paragraph],
      [title: Paragraph, numberDepth: int],
      [title: Paragraph],
      [indentation: float, title: String, numberDepth: int],
      [indentation: float, title: String],
      [title: String, numberDepth: int],
      [title: String]
    ]
  }

  /**
   * Creates a new Section node.
   * Sections are created by invoking addSection() on a Chapter or Section.
   * @param builder The builder.
   * @param ctorArgs The constructor (i.e. addSection()) arguments.
   * @return The new Section.
   */
  @Override def createInstance(FactoryBuilderSupport builder, Object ctorArgs) {
    InvokerHelper.invokeMethod(builder.current, "addSection", ctorArgs)
  }

  @Override
  void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    // Do nothing.  Sections are created already added to their parents.
  }

}
