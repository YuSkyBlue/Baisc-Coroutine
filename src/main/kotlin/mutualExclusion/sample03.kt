package org.example.mutualExclusion

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

private suspend fun accessLimitedResource(semaphore: Semaphore, taskNumber: Int) {
    semaphore.withPermit {
        // Section that only a limited number of coroutines can enter at a time
        println("Task $taskNumber is accessing the limited resource...")
        delay(1000) // Simulate some work with the limited resource
        println("Task $taskNumber finished accessing the limited resource.")
    }
}

private fun main() = runBlocking {
    val semaphore = Semaphore(permits = 3) // Allows up to 3 coroutines to access the resource concurrently
    val jobs = List(10) { taskNumber ->
        launch {
            accessLimitedResource(semaphore, taskNumber)
        }
    }
    jobs.forEach { it.join() } // Wait for all jobs to complete
}