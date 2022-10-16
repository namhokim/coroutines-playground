package com.github.namhokim.courseleonardo.ex.part1.section1

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("launch: ${Thread.currentThread().name}")   // 3
        println("World!")                                   // 4
    }
    println("runBlocking: ${Thread.currentThread().name}")  // 1
    Thread.sleep(500L)
    println("Hello")                                        // 2
}
