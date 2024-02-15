package mutualExclusion

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit

/**Semaphore */
private fun main() = runBlocking {
    val semaphore = Semaphore(permits = 3) // Limit to 3 concurrent tasks

    val tasks = List(10) { taskNumber ->
        launch {
            accessResource(semaphore, taskNumber)
        }
    }

    tasks.forEach { it.join() } // Wait for all tasks to complete
}

private suspend fun accessResource(semaphore: Semaphore, taskNumber: Int) {
    semaphore.withPermit {
        println("Task $taskNumber is accessing the resource...")
        delay(1000) // Simulate work by suspending the coroutine for 1 second
        println("Task $taskNumber finished accessing the resource.")
    }
}

