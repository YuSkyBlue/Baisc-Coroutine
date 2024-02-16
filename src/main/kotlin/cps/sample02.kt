package org.example.cps

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume


private fun main() {
    goWork()
}
fun goWork() {
    var label = 1
    val doStep = Continuation<Unit>(context = Dispatchers.Default) {
        when (label) {
            1 -> println("집에서 준비하기")
            2 -> println("나가서 이동하기")
            3 -> println("출근해서 일하기")
        }
    }

    val rollbackStep = Continuation<Unit>(context = Dispatchers.Default) {
        println("rollbackStep: ${Thread.currentThread().name}")

        label--
    }

    val procStep = Continuation<Unit>(context = Dispatchers.Default) {
        println("procStep: ${Thread.currentThread().name}")

        label++
    }

    doStep.resume(Unit) // 집에서 준비하기
    procStep.resume(Unit) // 준비 끝났으니 나가자!

    doStep.resume(Unit) // 회사로 이동하는중~
    rollbackStep.resume(Unit) // 아맞다 사원증! 집으로 빠꾸

    doStep.resume(Unit) // 다시 집에서 사원증 챙겨나오기
    procStep.resume(Unit) // 사원증 챙겼으니 다시 나가자!

    doStep.resume(Unit) // 회사로 이동~
    procStep.resume(Unit) // 출근 완료!

    doStep.resume(Unit) // 출근해서 일하기
}