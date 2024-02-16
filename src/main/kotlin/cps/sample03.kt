package org.example.cps

import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.resume


fun main() {
    var visited = false
    val firstContinuation = Continuation<Unit>(context = EmptyCoroutineContext) {
        when (visited) {
            true -> println("Visited")
            else -> println("Not visited")
        }
    }
    val secondContinuation = Continuation<Unit>(context = EmptyCoroutineContext) {
        visited = true
    }
    firstContinuation.resume(Unit) // Not visited
    secondContinuation.resume(Unit)
    firstContinuation.resume(Unit) // Visited
}