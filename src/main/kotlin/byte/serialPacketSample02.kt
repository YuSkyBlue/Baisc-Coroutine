package org.example.byte


// Main function to simulate the file transfer
private fun main() {
    // Simulating a file broken into packets for transfer
    val filePackets = listOf(
        byteArrayOf(0x01, 0x02), // Packet 1 (Checksum pass)
        byteArrayOf(0x03, 0x04), // Packet 2 (Checksum fail)
        byteArrayOf(0x05, 0x06)  // Packet 3 (Checksum pass)
    )

    fileTransfer(filePackets)
}
private fun checksum(packet: ByteArray): Boolean {
    // Dummy checksum function for illustration
    // Returns true if the sum of bytes is even, simulating a simple integrity check
    return packet.sumOf { it.toInt() } % 2 == 0
}

private fun sendPacket(packet: ByteArray): ByteArray {
    // Simulate packet sending and receiving an ACK/NACK
    // In real-world, this involves writing to and reading from a serial port

    return if (checksum(packet)) {
        println("Packet sent successfully. Waiting for ACK...")
        byteArrayOf(0x06) // Simulating ACK
    } else {
        println("Packet corrupted. Waiting for NACK...")
        byteArrayOf(0x15) // Simulating NACK
    }
}

private fun fileTransfer(packets: List<ByteArray>) {
    packets.forEachIndexed { index, packet ->
        var ackReceived = false
        var attempts = 0

        while (!ackReceived && attempts < 3) { // Retry limit of 3 attempts per packet
            val response = sendPacket(packet)
            if (response.contentEquals(byteArrayOf(0x06))) { // ACK received
                println("ACK received for packet $index. Proceeding to next packet.")
                ackReceived = true
            } else { // NACK received or no response
                println("NACK received for packet $index. Retrying...")
                attempts++
            }
        }

        if (!ackReceived) {
            println("Failed to send packet $index after 3 attempts. Aborting transfer.")
            return
        }
    }

    println("File transfer complete.")
}

