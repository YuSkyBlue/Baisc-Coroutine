package org.example.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking{
    this.launch {
        myWorld()
    }
    println("Hello,")

}

suspend fun myWorld(){
    delay(1000L)
    println("world.")
}