package org.example.cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout


private fun main() = runBlocking {
    withTimeout(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
}

//private fun main() = runBlocking {
//    withTimeout(1300L){
//        try {
//            repeat(1000) {i ->
//                println("i'm sleeping $i")
//                delay(500L)
//            }
//        } catch (e : Exception){
//            println(e.printStackTrace())
//        }
//
//    }
//}