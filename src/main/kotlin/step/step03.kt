import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class LockBasedBoundedQueue<T>(val capacity: Int) {
    private val lock = ReentrantLock()
    private val notEmpty = lock.newCondition()
    private val notFull = lock.newCondition()
    private val queue = ArrayDeque<T>(capacity)

    fun enqueue(item: T) {
        lock.withLock {
            while (queue.size == capacity) {
                notFull.await() // Wait until the queue is not full
            }
            queue.addLast(item)
            notEmpty.signal() // Signal that the queue is not empty
        }
    }

    fun dequeue(): T {
        lock.withLock {
            while (queue.isEmpty()) {
                notEmpty.await() // Wait until the queue is not empty
            }
            val item = queue.removeFirst()
            notFull.signal() // Signal that the queue is not full
            return item
        }
    }
}
