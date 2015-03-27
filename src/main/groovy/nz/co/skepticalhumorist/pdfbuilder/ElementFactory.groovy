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

import com.lowagie.text.pdf.MultiColumnText
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import org.codehaus.groovy.runtime.InvokerHelper

class ElementFactory extends AbstractFactory {

  Class elementClass
  List ctorArgTypes

  Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
    return mutatingInitialisation(builder, value, attributes)
  }

  // It's nasty to mutate the attributes Map we're called with.
  // But FactoryBuilderSupport is hardcoded to try to apply setters for attributes in the map,
  // after it calls newInstance.
  // We need to do our own property setting, because of some of the ambiguities in the iText API.
  // (Multiple setters for the same property name with arguments of different types.)
  // Therefore we need to prevent FactoryBuilderSupport seeing these attributes.
  private Object mutatingInitialisation(FactoryBuilderSupport builder, value, Map attributes) {
    def ctorArgs = getArgs(attributes, value)
    def result = createInstance(builder, ctorArgs)
    if (attributes.containsKey("init")) {
      Closure init = attributes.remove("init")
      init(result)
    }
    attributes.each {String property, Object val ->
      ReflectionUtils.setProperty(result, property, val)
    }
    attributes.clear()
    return result
  }

  // See mutatingInitialisation() above.
  // If we could get around the FactoryBuilderSupport handling of attributes,
  // we could use this method instead, which is nicer because it does not mutate arguments.
  private Object nonMutatingInitialisation(FactoryBuilderSupport builder, Object value, Map attributes) {
    def ctorArgMap = ctorArgMap(ctorArgTypes, attributes)
    def ctorArgs = ctorArgMap ? ctorArgMap.values().toArray() : value
    def result = createInstance(builder, ctorArgs)
    if (attributes.containsKey("init")) {
      Closure init = (Closure) attributes["init"]
      init(result)
    }
    def otherProperties = attributes.subMap(attributes.keySet() - ctorArgMap.keySet() - "init")
    otherProperties.each {String property, Object val ->
      ReflectionUtils.setProperty(result, property, val)
    }
    return result

  }

  static Map ctorArgMap(List<Map<String, Class>> argTypeMaps, Map<String, Object> attributes) {
    for (argTypeMap in argTypeMaps) {
      def argNames = argTypeMap.keySet()
      if (attributes.keySet().containsAll(argNames)) {
        return attributes.subMap(argNames)
      }
    }
    return [:]
  }

  def createInstance(FactoryBuilderSupport builder, ctorArgs) {
    return InvokerHelper.invokeConstructorOf(elementClass, ctorArgs)
  }

  def getArgs(Map attributes, value) {
    return PDFBuilder.argsFromAttributes(ctorArgTypes, attributes, value)
  }

  @Override
  void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
    switch (parent) {
      case MultiColumnText: parent.addElement(node); break;
      case PdfPCell: parent.addElement(node); break;
      case PdfPTable: parent.addCell(node); break;
      default: parent.add(node)
    }
  }

}
