package org.example.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    this.launch {
        delay(1000L)
        println("World!")
    }

    this.launch {
        delay((1000L))
        println("World")
    }

    println("Hello,")
}