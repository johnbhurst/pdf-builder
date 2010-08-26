@Grab("com.lowagie:itext:2.1.7")
import com.lowagie.text.Element
import groovy.xml.MarkupBuilder
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.util.jar.JarEntry
import java.util.jar.JarInputStream

def classExtends(Class cls) {
  def result = cls.superclass
  result == null || result == Object ? "" : result.simpleName
}

def classConstructors(Class cls) {
  def result = []
  cls.constructors.each {Constructor ctor ->
    if (Modifier.isPublic(ctor.modifiers)) {
      result << cls.simpleName + "(" + ctor.parameterTypes.toList()*.simpleName.join(", ") + ")"
    }
  }
  result
}

def classAddMethods(Class cls) {
  def result = []
  cls.methods.each {Method method ->
    if (Modifier.isPublic(method.modifiers) && method.name.startsWith("add")) {
      result << method.name + "(" + method.parameterTypes.toList()*.simpleName.join(", ") + ")"
    }
  }
  result
}

URLClassLoader loader = Element.classLoader
def elementClasses = []
loader.URLs.each {URL url ->
  url.withInputStream {InputStream is ->
    JarInputStream jis = new JarInputStream(is)
    JarEntry entry = jis.nextJarEntry
    while (entry != null) {
      if (!entry.isDirectory() && entry.name.endsWith(".class")) {
        String className = entry.name.replace(".class", "").replace("/", ".")
        try {
          Class cls = loader.loadClass(className)
          if (Element.isAssignableFrom(cls)) {
            elementClasses << cls
          }
        }
        catch (NoClassDefFoundError ok) {}
      }
      entry = jis.nextJarEntry
    }
  }
}
elementClasses = elementClasses.sort {a, b -> a.simpleName <=> b.simpleName}
new File("doc/iText-Elements.html").withWriter {writer ->
  new MarkupBuilder(writer).html {
    body {
      p("""
      This table shows all the classes that implement the Element interface.
      For each class is shown:
      """)
      ul {
        li("Its parent class")
        li("Its public constructors")
        li("Its methods starting with \"add\"")
      }
      p("""
      These features are used to determine nesting and add...() behaviour in the pdf-builder DSL.
      """)
      table(border: 1) {
        tr {
          th("Class")
          th("Extends")
          th("Constructors")
          th("addXxx() methods")
        }
        elementClasses.each {cls ->
          tr(valign: "top") {
            td(cls.simpleName)
            td(classExtends(cls))
            td {
              classConstructors(cls).eachWithIndex {ctor, i ->
                if (i != 0) br()
                span(ctor)
              }
            }
            td {
              classAddMethods(cls).eachWithIndex {method, i ->
                if (i != 0) br()
                span(method)
              }
            }
          }
        }
      }
    }
  }
}


