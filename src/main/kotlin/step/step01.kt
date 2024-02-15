package org.example.step

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun step01(){
    print("Start Main Thread")

    runBlocking {
        GlobalScope.launch() {
            repeat(10) {
                delay(1000L)
                println("I'm working in Coroutine.")
            }
        }.join()
    }
    print("End Main Thread")

    /**
     * Sampe as This code about thread
     */
//    Thread(Runnable {
//        for(i in 1..10) {
//            Thread.sleep(1000L)
//            print("I'm working in Thread.")
//        }
//    }).start()
}

private fun main(){
    step01()
}