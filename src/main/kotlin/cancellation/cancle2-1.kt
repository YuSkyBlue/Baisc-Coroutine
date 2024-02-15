package org.example.cancellation

import kotlinx.coroutines.*

private fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                yield()
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}


//private fun main() = runBlocking {
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
//        while (i < 10) {
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                yield() // Allows for cooperative cancellation, if needed
//                println("job: I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
//    }
//    // Wait for the job to complete instead of cancelling it
//    job.join()
//    println("main: Job is complete. Now I can quit.")
//}