package org.example.byte


// Main function to simulate the process
private fun main() {
    val receivedPacket = receivePacket()
    println("Received packet: ${receivedPacket.toHexString()}")

    val response = processPacket(receivedPacket)
    sendResponse(response)
}

// Function to simulate receiving a packet from the serial port
private fun receivePacket(): ByteArray {
    // Simulate receiving a data packet
    // In a real scenario, this would come from the serial port
    return byteArrayOf(0x02, 0x37, 0x34) // Example packet data
}

// Function to simulate sending a response to the serial port
private fun sendResponse(response: ByteArray) {
    // In a real scenario, you would write this response back to the serial port
    println("Sending response: ${response.toHexString()}")
}

// Function to process received packets and decide whether to ACK or NACK
private fun processPacket(packet: ByteArray): ByteArray {
    // Example processing logic
    // Return ACK for demonstration purposes if packet starts with 0x02, else NACK
    return if (packet.isNotEmpty() && packet[0] == 0x02.toByte()) {
        byteArrayOf(0x06) // ACK
    } else {
        byteArrayOf(0x15) // NACK
    }
}

// Helper function to convert ByteArray to Hex String for printing
fun ByteArray.toHexString() = joinToString(separator = " ") { byte -> "%02x".format(byte) }

