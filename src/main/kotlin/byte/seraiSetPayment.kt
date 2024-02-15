package org.example.byte

import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

private var ackReceived = CompletableDeferred<Boolean>()

private lateinit var paymentScope: CoroutineScope
private var paymentJob: Job? = null

private fun setPaymentScope() {
    paymentJob = Job()
    paymentScope = CoroutineScope(Dispatchers.IO + paymentJob!!)

    paymentScope.launch {
        // Your existing code to send the packet and then wait for an ACK
        val packet = "Sample packet" // Replace this with your packet preparation logic

        println("Sending packet: $packet")
        // Simulating serial port write delay
        delay(1000)

        // Simulating ACK reception
        val ackReceived = true // Assuming ACK is received
        if (ackReceived) {
            // Proceed with processing after receiving ACK
            println("ACK received. Proceeding with processing.")
        } else {
            // Handle failure (no ACK or NACK received)
            println("Failure: No ACK or NACK received.")
        }
    }
}

fun main() {
    setPaymentScope()

    // Main thread continues here
    println("Main thread continuing...")

    // Wait for a while to ensure the coroutine finishes (just for this example)
    Thread.sleep(2000)

    // Cancel the coroutine to release resources
    paymentJob?.cancel()

    println("Main thread exiting...")
}