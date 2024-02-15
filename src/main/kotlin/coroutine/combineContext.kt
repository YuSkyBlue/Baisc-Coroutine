package org.example.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf

private fun main() = runBlocking {
    val flow1 = flowOf("A", "B", "C")
    val flow2 = flowOf(1, 2, 3)

    // Combine the latest values of two flows and emit their combination
    flow1.combine(flow2) { a, b ->
        "$a$b"
    }.collect { value ->
        println(value) // This will print combinations of the latest emissions from both flows
    }
    setupCoroutineScope()
}
private suspend fun setupCoroutineScope(){
    val paymentJob = Job()
    val paymentScope = CoroutineScope(Dispatchers.IO + paymentJob)

    paymentScope.launch {
        // Simulate a long-running IO task
        delay(1000L)
        println("IO task completed")
    }

}