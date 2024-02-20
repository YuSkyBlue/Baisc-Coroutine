package org.example.step

import LockBasedBoundedQueue
import java.util.concurrent.atomic.AtomicReference
import kotlin.system.measureNanoTime

class LockFreeStack<T> {
    private val top = AtomicReference<Node<T>?>(null)

    fun push(value: T) {
        val newNode = Node(value)
        var currentTop: Node<T>?
        do {
            currentTop = top.get()
            newNode.next = currentTop
        } while (!top.compareAndSet(currentTop, newNode))
    }

    fun pop(): T? {
        var currentTop: Node<T>?
        var newTop: Node<T>?
        do {
            currentTop = top.get()
            if (currentTop == null) {
                return null // Stack is empty
            }
            newTop = currentTop.next
        } while (!top.compareAndSet(currentTop, newTop))
        return currentTop?.value
    }

    private class Node<T>(val value: T, @Volatile var next: Node<T>? = null)
}

fun main() {
    val lockBasedQueue = LockBasedBoundedQueue<Int>(1000)
    val lockFreeStack = LockFreeStack<Int>()

    // Test LockBasedBoundedQueue
    val lockBasedQueueTime = measureNanoTime {
        val producer = Thread {
            repeat(1000) {
                lockBasedQueue.enqueue(it)
            }
        }
        val consumer = Thread {
            repeat(1000) {
                lockBasedQueue.dequeue()
            }
        }

        producer.start()
        consumer.start()

        producer.join()
        consumer.join()
    }

    // Test LockFreeStack
    val lockFreeStackTime = measureNanoTime {
        val producer = Thread {
            repeat(1000) {
                lockFreeStack.push(it)
            }
        }
        val consumer = Thread {
            repeat(1000) {
                lockFreeStack.pop()
            }
        }

        producer.start()
        consumer.start()

        producer.join()
        consumer.join()
    }

    println("LockBasedBoundedQueue Time: $lockBasedQueueTime ns")
    println("LockFreeStack Time: $lockFreeStackTime ns")
}