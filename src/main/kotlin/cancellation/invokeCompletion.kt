package org.example.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


private fun main() = runBlocking {
    // Launching a new coroutine in the scope of runBlocking
    val job = launch {
        println("Coroutine is doing some work")
        delay(1000L) // Simulating a long-running task
        println("Coroutine work is done")
    }

    // Attaching an invokeOnCompletion handler to the coroutine job
    job.invokeOnCompletion { cause ->
        if (cause != null) {
            println("Coroutine was cancelled due to an exception: ${cause.message}")
        } else {
            println("Coroutine completed successfully.")
        }
    }

    // Uncomment the next line to see the cancellation scenario
    // job.cancel(CancellationException("Intentional cancellation"))

    // Waiting for the coroutine to finish to keep the application alive
    job.join() // == null -> casuse
//    job.cancelAndJoin() // else -> invokeCompletion
    println("Main program is done")
}