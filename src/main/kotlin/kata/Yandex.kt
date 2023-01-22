import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val count = sc.nextLine().toInt()

    val lines = mutableListOf<String>()
    repeat(count) { lines.add(sc.nextLine()) }

    val rootView = parseViewHierarchy(lines)

    val point = sc.nextLine().split(" ")
    val x = point[0].toInt()
    val y = point[1].toInt()
    val hitView = hitTest(rootView, x, y)

    println(hitView?.name ?: "null")
}

fun parseViewHierarchy(lines: List<String>): View {
    val rootLine = lines[0].split(" ")
    val root = ViewGroup(
        rootLine[0], rootLine[1].toInt(),
        rootLine[2].toInt(), rootLine[3].toInt(), rootLine[4].toInt()
    )

    val remainingLines = lines.drop(1)

    remainingLines.forEach { line ->

        val viewString = line.split(" ")
        val viewName = viewString[0]

        val viewHasChildren = remainingLines.any {
            it.split(" ")[5] == viewName
        }

        val view = if (viewHasChildren) {
            View(
                name = viewName,
                left = viewString[1].toInt(),
                top = viewString[2].toInt(),
                right = viewString[3].toInt(),
                bottom = viewString[4].toInt(),
            )
        } else {
            ViewGroup(
                name = viewName,
                left = viewString[1].toInt(),
                top = viewString[2].toInt(),
                right = viewString[3].toInt(),
                bottom = viewString[4].toInt(),
            )
        }

        root.addView(view)
    }
    // rootLine[5] is parent name, which is null for the root view

    // TODO : parse remaining views
    // If view has no children, it should be View (and ViewGroup otherwise)

    return root
}

fun hitTest(root: View, x: Int, y: Int): View? {
    return root
}

open class View(
    val name: String,
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int,
    val parentName: String = "null"
)

class ViewGroup(
    name: String, left: Int, top: Int, right: Int, bottom: Int,
) : View(name, left, top, right, bottom) {

    private val children = mutableListOf<View>()

    fun getChildCount() = children.size
    fun getChildAt(index: Int) = children[index]
    fun addView(child: View) = children.add(child)
}