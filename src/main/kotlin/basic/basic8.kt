package org.example.basic

import kotlinx.coroutines.*
//
//private fun main() = runBlocking {
//    repeat(100_000) {
//        launch {
//            delay(1000L)
//            print(".")
//        }
//    }
//}


private fun main() = runBlocking {
    repeat(100_000) { i ->
        launch {
            delay(i * 100L) // Each coroutine starts 100ms after the previous one
            print(".")
        }
    }
}