package org.example.cancellation

import kotlinx.coroutines.*

/** 데이터베이스를 롤백하는 경우 주로 사용 */
private fun main() = runBlocking {
    val job = launch {
        try{
            repeat(1000) { i ->
                println("job : I;m sleeping $i... ")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable){ // 내부에서 코루틴을 취소할 수 없는 context
                println("job ; Im runnig finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}