package org.example.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val job = GlobalScope.launch {
        delay(3000L)
        println("world!")
    }

    println("Hello, ")
    job.join()
}