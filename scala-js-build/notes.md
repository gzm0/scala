## Notes / Issues

- `nsc.io` uses `java.nio` extensively
- Instantiations of Java collection classes make the following
  reachable through the `corejslib.js` and `toString`:
  - `ju_HashSet`
  - `ju_LinkedHashSet`
  - `ju_HashMap`
  - `ju_Map$Entry`
- nsc uses properties in files to read essential data (like Scala
  version, etc.)
- Following are used in `scala.reflect.io`
  - `java.io.File` (extensively!)
  - `java.util.zip.ZipFile`
- `scala.tools.util.PathResolver` references `java.io.File` a lot.
- `scala.reflect.internal.StdNames` uses
  `Ljava_security_MessageDigest$` to retrieve md5 function
- `s_tools_nsc_util_ClassPath` uses ClassLoaders

## Needed classes

- `Ljava_io_PrintWriter`
- `Ljava_io_BufferedReader`
- `Ljava_io_BufferedInputStream`
- `ju_regex_PatternSyntaxException`
- `jl_ref_referenceQueue`?
