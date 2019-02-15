fun main() {
    println(7 divides 10)
    println((0..100).filter { it.isPrime() })
    println(primes.take(10).toList())
    println(goldbach(4))
    println("Goldbach widerlegt? => " + (4..100).step(2).any { goldbach(it).size == 0 })
}

val primes = sequence {
    for (i in 0..Int.MAX_VALUE) {
        if (i.isPrime()) yield(i)
    }
}

fun Int.isPrime(): Boolean {
    return when {
        this in 0..1 -> false
        this == 2 -> true
        2 divides this -> false
        else -> (3..this).filter { it*it <= this }.any { it divides this }.not()
    }
}

infix fun Int.divides(i: Int) = i % this == 0

fun goldbach(n: Int) =
    primes.take(n / 2)
        .filter { it <= n / 2 }
        .filter { (n - it).isPrime() }
        .map { Pair(it, n - it) }
        .toList()



