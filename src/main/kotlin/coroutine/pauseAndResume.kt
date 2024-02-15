package org.example.coroutine

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(10) {
            println("Task $it is running")
            delay(500)
        }
    }

    // Simulate some work before pausing the job
    delay(1500)

    // Pause the job
    job.pause()

    println("Job paused. Performing some other work...")

    // Simulate some other work while the job is paused
    delay(2000)

    // Resume the job
    job.resume()

    // Cancel the job
    job.cancelJob()

    // Wait for the job to complete
    job.join()

    println("Job completed")
}

// Extension functions to add pause, resume, and cancel functionality
suspend fun Job.pause() {
    (this as? PausingJob)?.pause()
}

fun Job.resume() {
    (this as? PausingJob)?.resume()
}

suspend fun Job.cancelJob() {
    (this as? PausingJob)?.cancelJob()
}

interface PausingJob : Job {
    suspend fun pause()
    fun resume()
    suspend fun cancelJob()
}

class PausingJobImpl(parent: Job? = null) : Job by Job(parent), PausingJob {
    private val pauseSignal = CompletableDeferred<Unit>()

    init {
        invokeOnCompletion {
            pauseSignal.complete(Unit)
        }
    }

    override suspend fun pause() {
        pauseSignal.await()
    }

    override fun resume() {
        if (isCompleted) return

        // Reset the completion state
        start()

        // Clear the pause signal
        pauseSignal.complete(Unit)
    }

    override suspend fun cancelJob() {
        cancel()
    }
}