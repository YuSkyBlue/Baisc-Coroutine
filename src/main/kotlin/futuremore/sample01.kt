package org.example.futuremore

// 피보나치 수열 생성
val fibonacciSeq = sequence {
    var a = 0
    var b = 1
    yield(1)  // (1) 지연 함수가 사용되어 코루틴 생성

    while (true) {
        yield(a + b)  // (2)
        val tmp = a + b
        a = b
        b = tmp
    }
}
val seq = sequence {
    val start = 0
    // 단일 값 산출
    yield(start)
    // 반복 값 산출
    yieldAll(1..5 step 2)
    // 무한한 시퀀스에서 산출
    yieldAll(generateSequence(8) { it * 3 })
}


private fun main() {
    println(fibonacciSeq.take(8).toList())

    // 다음 요소에 대한 지정
    val saved = fibonacciSeq.iterator()
    println("${saved.next()}, ${saved.next()}, ${saved.next()}")
    println("---------------------------------------------------")
    println(seq.take(7).toList()) // [0, 1, 3, 5, 8, 24, 72]
}
