package org.example.cps


fun main() {
    worldContinutation {
        println("Bye, world!")
    }
}

private fun worldContinutation(callcc: () -> Unit) {
    println("Hi, world!")
    callcc()
    println("is it right?")
}