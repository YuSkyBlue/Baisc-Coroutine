package org.example.compose

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/** 2023ms 순차적으로 실행 */
private fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUseFulOne()
        val two = doSomethingUseFulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")
}

private suspend fun doSomethingUseFulOne(): Int {
    println("doSomethingUsefulOne - START")
    delay(1000L)
    println("doSomethingUsefulOne - END")
    return 13
}

private suspend fun doSomethingUseFulTwo(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}
