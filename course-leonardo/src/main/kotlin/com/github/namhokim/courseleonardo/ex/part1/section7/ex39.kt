package com.github.namhokim.courseleonardo.ex.part1.section7

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val elapsed = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("$elapsed ms 동안 ${n * k}개의 연산을 수행")
}

private var counter = 0

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            counter++
        }
    }
    println("Counter = $counter")
}
