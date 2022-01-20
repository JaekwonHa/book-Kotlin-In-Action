import java.io.File

object CaseInsentiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

println(CaseInsentiveFileComparator.compare(File("./14_object_class.kts"), File("./14_OBJECT_CLASS.kts")))
