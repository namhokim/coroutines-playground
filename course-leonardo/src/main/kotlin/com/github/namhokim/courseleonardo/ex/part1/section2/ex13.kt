package com.github.namhokim.courseleonardo.ex.part1.section2

import kotlinx.coroutines.*

suspend fun doOneTwoThree13() = coroutineScope {
    val job: Job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1500L)
        println("3!")
    }
    job.join()

    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }
    repeat(1_000_000) {
        launch {
            println("launch3: ${Thread.currentThread().name}")
            delay(500L)
            println("2!")
        }
    }
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree13()
    println("runBlocking: ${Thread.currentThread().name}")
    delay(100L)
    println("5!")
}
