package org.example

import java.time.Duration
import java.time.LocalDateTime

fun main() {
//    val array = arrayOf(2,7,11,15).toIntArray()
//    val target = 9

    val array = arrayOf(3,2,4).toIntArray()
    val target = 6
    twoSum(array, target)

}

private fun twoSum(nums: IntArray, target: Int): IntArray {

    val output = IntArray(2)
    for(i in 0..< nums.size){
        for(j in i+1..<nums.size){
            if(nums[i] + nums[j] == target){
                output[0] = i
                output[1] = j
                print("i:$i ,j : $j:")
            }
        }
    }
    return output
}