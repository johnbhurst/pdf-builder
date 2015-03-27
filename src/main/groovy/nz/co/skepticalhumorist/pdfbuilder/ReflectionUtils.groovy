// Copyright 2015- John Hurst
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

import java.lang.reflect.Method

class ReflectionUtils {

  // http://stackoverflow.com/questions/1704634/simple-way-to-get-wrapper-class-type-in-java
  private static Map<Class, Class> PRIMITIVES_TO_WRAPPERS = [
    (boolean): Boolean,
    (byte): Byte,
    (char): Character,
    (double): Number,    // Double: relaxed
    (float): Number,     //Float: relaxed
    (int): Number,       //Integer: relaxed
    (long): Number,      //Long: relaxed
    (short): Number,     //Short: relaxed
    (void): Void,
  ]

  static void setProperty(Object target, String property, Object value) {
    Method setter = getSetter(target.class, property, value.class)
    Class targetType = setter.parameterTypes[0]
    try {
      setter.invoke(target, [safeVal(targetType, value)] as Object[])
//      setter.invoke(target, [value] as Object[])
    }
    catch (Exception ex) {
      throw new RuntimeException("Exception setting property [$property] on type [${target.class}], with value type [${value.class}]", ex)
    }
  }

  // Groovy code using builders is likely to pass BigIntegers, BigDecimals, or other not-quite-right numeric types for attributes.
  // We'll take a pragmatic approach and coerce the types automatically to the right ones.
  static Object safeVal(Class targetType, Object value) {
    if (value == null) {
      return value
    }
    if (targetType.is(double) && value instanceof Number) {
      return ((Number) value).doubleValue()
    }
    if (targetType.is(float) && value instanceof Number) {
      return ((Number) value).floatValue()
    }
    if (targetType.is(int) && value instanceof Number) {
      return ((Number) value).intValue()
    }
    if (targetType.is(long) && value instanceof Number) {
      return ((Number) value).longValue()
    }
    if (targetType.is(short) && value instanceof Number) {
      return ((Number) value).shortValue()
    }
    return value
  }

  static Method getSetter(Class targetClass, String property, Class valueClass) {
    List<Method> setters = targetClass.methods
      .findAll {Method method -> method.name == "set${property.capitalize()}".toString() &&
                method.parameterTypes.size() == 1 &&
                assignableType(method.parameterTypes[0], valueClass)
    }
    if (setters.size() > 1) {
      throw new RuntimeException("Too many candidate setters for class [$targetClass] property [$property], for value class [$valueClass]")
    }
    if (setters.size() == 0) {
      throw new RuntimeException("No setter found for class [$targetClass] property [$property], for value [$valueClass]")
    }
    return setters[0]
  }

  static boolean assignableType(Class targetClass, Class sourceClass) {
    if (targetClass.isAssignableFrom(sourceClass)) {
      return true
    }
    if (PRIMITIVES_TO_WRAPPERS.containsKey(targetClass) &&
        PRIMITIVES_TO_WRAPPERS[targetClass].isAssignableFrom(sourceClass)) {
      return true
    }
    return false
  }

}
