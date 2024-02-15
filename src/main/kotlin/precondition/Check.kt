package org.example.precondition

private fun main(){
    val x = 10
    val y = 20

    check(x < y) { "Assertion failed: $x should be less than $y" }
    println("Assertion 1 passed")

    // Example 2: Checking if a condition is true
    val condition2 = x < 5
    check(condition2) { "Assertion failed: $condition2 should be true" }
    println("Assertion 2 passed")

    // Example 2: Checking if a condition is true
    val condition1 = x > 5
    check(condition1) { "Assertion failed: $condition1 should be true" }
    println("Assertion 3 passed")

    // Example 3: Failing assertion
    val a = 5
    val b = 3
    check(a > b) { "Assertion failed: $a should be greater than $b" } // This will throw an exception
    println("Assertion 3 passed")
}