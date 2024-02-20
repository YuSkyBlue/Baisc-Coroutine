package org.example.futuremore

import kotlinx.coroutines.*

private fun main() = runBlocking {

        launch {
            repeat(5) { i ->
                println("Coroutine A, iteration $i")
//                delay(100)
                yield() // Gives a chance for other coroutines to run
            }
        }

        launch {
            repeat(5) { i ->
                println("Coroutine B, iteration $i")
//                delay(100)
                yield() // Gives a chance for other coroutines to run
            }
        }
    println("Start")
}