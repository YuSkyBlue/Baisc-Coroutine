package org.example.multithread

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // this: CoroutineScope
    println("Main program starts: ${Thread.currentThread().name}")

    val job = launch { // launch a new coroutine and keep a reference to its Job
        println("Fake work starts: ${Thread.currentThread().name}")
        suspendFunction()
        println("Fake work finished: ${Thread.currentThread().name}")
    }

    // Wait until the coroutine completes
    job.join()

    println("Main program ends: ${Thread.currentThread().name}")
}

suspend fun suspendFunction() {
    println("Suspending function starts: ${Thread.currentThread().name}")
    delay(2000) // simulates a long-running operation
    println("Suspending function ends: ${Thread.currentThread().name}")
}