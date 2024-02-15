package org.example.compose

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/** 1013ms 동시에 두개를 실행 결과값이 도달할때까지 기달 */
//launch는 Job을 반환하며 이를 통해 상태 관리를 할 수 있다.
//async는 Deferred를 반환하며 이를 통해 상태 관리와 결과값에 접근할 수 있다.
private fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
//        delay(2000L)
//        println("test..")
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

private suspend fun doSomethingUsefulOne(): Int {
    println("doSomethingUsefulOne - START")
    delay(1000L)
    println("doSomethingUsefulOne - END")
    return 13
}

private suspend fun doSomethingUsefulTwo(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}

private suspend fun doSomethingUsefulOne1(): Int {
    println("doSomethingUsefulOne - START")
    delay(2000L)
    println("doSomethingUsefulOne - END")
    return 13
}

private suspend fun doSomethingUsefulTwo1(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}