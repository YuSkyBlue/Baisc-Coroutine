package org.example.context

import kotlinx.coroutines.*

private class Activity {
    private val mainScope = CoroutineScope(Dispatchers.Default)

    fun destroy() {
        mainScope.cancel()
    }

    fun doSomething() {
        repeat(10) { i ->
            mainScope.launch {
//                println("I'm working in thread ${Thread.currentThread().name}")
                delay((i+1) * 200L)
                println("Coroutine $i is done")
            }
        }
    }
}

fun main() = runBlocking<Unit>() {
    val activity = Activity()
//    println("I'm working in thread ${Thread.currentThread().name}")
    activity.doSomething()
    println("Launched coroutines")
    delay(500L)
    println("Destroying activity!")
    activity.destroy()
    delay(1000L)

}