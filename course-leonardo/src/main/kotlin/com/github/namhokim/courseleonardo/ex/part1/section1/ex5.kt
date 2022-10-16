package com.github.namhokim.courseleonardo.ex.part1.section1

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("launch: ${Thread.currentThread().name}")   // 2
        // delay (100L) vs delay (600L)
        println("World!")                                   // 3
    }
    println("runBlocking: ${Thread.currentThread().name}")  // 1
    delay(500L) // vs Thread.sleep(500L)
    println("Hello")                                        // 4
}
