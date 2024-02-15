package org.example.cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/** Non Null Return*/
private fun main() = runBlocking {
    // Increase the timeout or decrease the amount of work to ensure completion within the timeframe
    val result = withTimeoutOrNull(1300L) {
        repeat(2) { i -> // Decreased the number of iterations to ensure completion
            println("I'm sleeping $i ...")
            delay(500L) // Assuming each iteration takes at least 500ms
        }
        "Done" // This will be returned before the timeout
    }
    println("Result is $result")
}

/**  Null Return*/
//private fun main() = runBlocking {
//    val result = withTimeoutOrNull(1300L){
//        repeat(1000) { i->
//            println("I;m sleeping $i ...")
//            delay(500L)
//        }
//        "Done"
//    }
//    println("Result is $result")
//}