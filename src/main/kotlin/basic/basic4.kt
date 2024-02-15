package org.example.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("world")
    }

    println("Hello")
    delay(2000L)
}