fun main() {
    val liste = listOf("Klaus", "Klaus", "Manfred", "Helga", "Angelika", "Peter", "Hans", "Jürgen", "Stephan", "Boris")
    println(liste
        .quicksort()
        .also { println("==========================") }
        .quicksort())
}

fun <E: Comparable<E>> List<E>.quicksort(): List<E> {
    return if (this.size <= 1) this
    else {
        val pivot = first()
        val (left, right) = drop(1).partition { it < pivot }
        println("Left: $left, Right: $right")
        left.quicksort() + pivot + right.quicksort()
    }
}
