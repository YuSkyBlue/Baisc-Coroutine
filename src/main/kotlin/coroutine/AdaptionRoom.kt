package org.example.coroutine

import java.time.LocalDateTime
import java.util.logging.LogManager
import kotlin.random.Random

class AdaptionRoom(private val targetTemperature: Int) {
    private var currentTemperature: Int = targetTemperature
//    private val logger = LogManager.getLogger(AdaptionRoom::class.java.simpleName)

    init {
        // Simulate environment changes
        simulateEnvironment()
    }

    private fun adjustTemperature() {
        if (currentTemperature < targetTemperature) {
            println("Room is too cold. Increasing temperature.")
            currentTemperature++
        } else if (currentTemperature > targetTemperature) {
            println("Room is too warm. Decreasing temperature.")
            currentTemperature--
        }
        // Log the adjustment and current status
        println("Adjusted temperature to $currentTemperature°C. Target is $targetTemperature°C.")
    }

    private fun simulateEnvironment() {
        // This is a placeholder for a real environmental effect simulation
        Thread {
            while (true) {
                // Simulate external temperature influence
                currentTemperature += Random.nextInt(-2, 3)
                println("External influences adjusted room temperature to $currentTemperature°C.")
                adjustTemperature()

                // Wait for a bit before simulating the next environmental change
                Thread.sleep(5000) // 5 seconds
            }
        }.start()
    }
}

private fun main() {
    val adaptionRoom = AdaptionRoom(targetTemperature = 22) // Target room temperature is 22°C
}
