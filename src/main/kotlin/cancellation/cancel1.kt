package org.example.cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    var job = launch {
        repeat(1000) { i->
            println("job : I'm Sleepinhg $i")
            delay(500L)
        }
    }
    delay(1300L)
    println("main : I'm tired of Waiting")
    job.cancel()
    job.join()
    println("main: Now I can quit")
}