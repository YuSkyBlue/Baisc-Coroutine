package org.example.cancellation

import kotlinx.coroutines.*

private fun main() {
    val paymentJob = Job()
    val paymentScope = CoroutineScope(Dispatchers.IO + paymentJob)

    paymentScope.launch {
        try {
            // Simulate some work
            println("Work Start")
            delay(5000) // This is a cancellable suspending function
            println("Work Completed") // This line will not be reached if the job is cancelled before delay completes
        } catch (e: CancellationException) {
            println(e.printStackTrace())
            println("Coroutine was cancelled")
        }
    }
    // Somewhere else in your code, you cancel the job
    paymentJob.cancel() // This will cancel the coroutine launched in paymentScope
}