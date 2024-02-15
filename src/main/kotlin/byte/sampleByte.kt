package org.example.byte


import java.nio.ByteBuffer

/**
 * ByteArray 의 특정 위치부터 4 Byte 를 추출하여 Int 형태로 변환
 *
 * @param position ByteArray 시작 인덱스
 * @param littleEndian 빅엔디안, 리틀엔디안 구분
 * @return [Int] 변환 된 Integer
 */
private fun ByteArray.toInt(position: Int, littleEndian: Boolean = true): Int {
    if (this.size < position + 4) {
        println("This logs to standard error.")
        return 0
    }

    val intByteArray = copyOfRange(position, position + 4)

    if (littleEndian)
        intByteArray.reverse()

    return ByteBuffer.wrap(intByteArray).int
}

private fun main() {
    // Example ByteArray with less than 4 bytes.
    val byteArray1 = byteArrayOf(0x01, 0x02, 0x03) // Only 3 bytes long
    val byteArray2 = byteArrayOf(0x01, 0x02, 0x03, 0x04, 0x05) // Only 3 bytes long

    // Attempt to convert to Int starting from position 0 (should succeed).
    println("Result with sufficient bytes: ${byteArray2.toInt(0)}")

    // Attempt to convert to Int starting from a position that makes it impossible
    // to read 4 bytes, thus triggering the error.
    println("Result with insufficient bytes: ${byteArray2.toInt(2)}")
}
