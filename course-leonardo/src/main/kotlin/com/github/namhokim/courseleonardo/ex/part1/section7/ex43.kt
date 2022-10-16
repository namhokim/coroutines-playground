package com.github.namhokim.courseleonardo.ex.part1.section7

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val elapsed = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                repeat(k) {
                    action()
                }
            }
        }
    }
    println("$elapsed ms 동안 ${n * k}개의 연산을 수행")
}

private val mutex = Mutex()
private var counter = 0

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            mutex.withLock {
                counter++
            }
        }
    }
    println("Counter = $counter")
}
