package org.example.basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private fun main(){
    GlobalScope.launch {
        delay(1000L)
        println("world")
    }
    println("Hello")
    Thread.sleep(2000L)
}