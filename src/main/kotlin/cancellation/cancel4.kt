package org.example.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/** try (Catch) finally 시에 종료하면 Finally 실행 됨 그리고 job 종료 */
private fun main() = runBlocking {
    val job = launch {
        try{
            repeat(1000) {i ->
                println("job is sleeping $i")
                delay(500L)
            }
        } finally {
            println("job is finally")
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit ")
}