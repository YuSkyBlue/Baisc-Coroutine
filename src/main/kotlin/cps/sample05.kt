package org.example.cps

fun main() {
    directPrint("Hello, world!")
    continuationPrint("Bye, world!", ::println)
}

private fun directPrint(value: Any) {
    println(value)
}

private fun continuationPrint(
    value: Any,
    print: (value: Any) -> Unit,
) {
    print(value) // Call/CC
}