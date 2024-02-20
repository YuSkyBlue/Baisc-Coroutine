package org.example.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        if (i == 2) throw Exception("Error on $i") // simulate an error
        emit(i) // emit next value
    }
}

private fun main() = runBlocking<Unit> {
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Handle errors and collect the flow
    simple()
        .onEach { value -> println(value) } // act on each value as it is emitted
        .catch { e -> println("Caught $e") } // handle any errors that occur in the flow
        .onCompletion { println("Flow completed") } // do something on completion of the flow
        .collect() // trigger the flow to start emitting and processing values
}

// Make sure to have coroutines core dependency in your build.gradle to run this code
