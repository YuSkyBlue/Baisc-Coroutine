package org.example.basic

import kotlin.concurrent.thread

private fun main(){
    thread {
        Thread.sleep(2000L)
        println("World")
    }
    println("Hello,")
    Thread.sleep(2000L)
}