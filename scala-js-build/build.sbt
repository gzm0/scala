scalaJSSettings

scalaVersion := "2.11.2"

val srcBase = baseDirectory(_ / ".." / "src")

val dirs = Seq(
  "reflect",
  "compiler"
)

val excl = Set(
  "compiler/scala/tools/ant",
  "compiler/scala/tools/nsc/backend/jvm"
)

unmanagedSourceDirectories in Compile ++= dirs.map(srcBase.value / _)

excludeFilter in unmanagedSources in Compile := {
  val exD = excl.map(srcBase.value / _)
  def doExcl(f: File): Boolean = {
    if (f == null || f == srcBase.value) false
    else if (exD.contains(f)) true
    else doExcl(f.getParentFile)
  }
  (excludeFilter in unmanagedSources in Compile).value || new SimpleFileFilter(doExcl)
}
