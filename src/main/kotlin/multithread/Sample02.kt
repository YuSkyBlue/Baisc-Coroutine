package org.example.multithread

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        try {
            for (i in 1..5) {
                // Simulate long running task
                println("Operation $i is in progress")
                delay(500) // time-consuming task
            }
        } catch (e: CancellationException) {
            println("Coroutine was cancelled")
        } finally {
            withContext(NonCancellable) {
                println("Clean up action that cannot be cancelled")
            }
        }
    }

    delay(1200) // delay a bit
    println("Requesting to stop coroutine")
    job.cancelAndJoin() // cancel the coroutine and wait for its completion

    println("Coroutine stopped")

    // To "resume" or restart the coroutine, simply launch it again
    val restartedJob = launch(Dispatchers.Default) {
        for (i in 1..5) {
            // Simulate long running task
            println("Restarted operation $i is in progress")
            delay(500) // time-consuming task
        }
    }

    restartedJob.join() // Wait for the restarted coroutine to finish
    println("Restarted coroutine completed")
}
