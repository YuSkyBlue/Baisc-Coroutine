package org.example.cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


private fun main() = runBlocking {
    val job = launch {
        var treasureFound = false
        var attempts = 0
        while (!treasureFound) {
            attempts++
            println("Attempt $attempts: Searching for the treasure...")
            delay(500L) // Simulating the time taken for each search attempt

            // Simulate the chance of finding the treasure
            if (Math.random() < 0.2) { // 20% chance to find the treasure each attempt
                treasureFound = true
                println("Hooray! Found the treasure in attempt $attempts.")
            }

            // Check if too many attempts have been made
            if (attempts >= 10) {
                println("Too many attempts. The treasure remains elusive.")
                break
            }
        }
    }

    // Wait for the coroutine to finish
    job.join()
    println("Game over. Thanks for playing!")
}