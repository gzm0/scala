import scala.reflect.runtime.{
  currentMirror => mirror,
  universe      => ru
}

object Test extends App {
  import ru._

  // Package symbol
  val packageSym = mirror.staticPackage("foo.bar")
  // Package object symbol
  val poSym = mirror.staticModule("foo.bar.package")

  // Type of annotation
  val annotTpe = typeOf[foo.annot]

  println(packageSym.typeSignature.members)

  // Check annotation is on package object
  assert(poSym.annotations match {
    case List(Annotation(`annotTpe`, _, _)) => true
    case _ => false
  })

  // Check annotation is on package
  assert(packageSym.annotations match {
    case List(Annotation(`annotTpe`, _, _)) => true
    case _ => false
  })

}
