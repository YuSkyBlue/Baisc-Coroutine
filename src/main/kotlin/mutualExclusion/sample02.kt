package mutualExclusion

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

private suspend fun updateSharedResource(mutex: Mutex, taskNumber: Int) {
    mutex.withLock {
        // Critical section that only one coroutine can enter at a time
        println("Task $taskNumber is updating the shared resource...")
        delay(1000) // Simulate some work with the shared resource
        println("Task $taskNumber finished updating the shared resource.")
    }
}

private fun main() = runBlocking {
    val mutex = Mutex()
    val jobs = List(10) { taskNumber ->
        launch {
            updateSharedResource(mutex, taskNumber)
        }
    }
    jobs.forEach { it.join() } // Wait for all jobs to complete
}