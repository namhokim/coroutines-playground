package com.github.namhokim.courseleonardo.ex.part1.section3

import kotlinx.coroutines.*

suspend fun doOneTwoThree14() = coroutineScope {
    val job1: Job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1500L)
        println("3!")
    }

    val job2: Job = launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }
    val job3: Job = launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(500L)
        println("2!")
    }
    delay(800L) // vs delay(300L)
    job1.cancel()
    job2.cancel()
    job3.cancel()
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree14()
    println("runBlocking: ${Thread.currentThread().name}")
    delay(100L)
    println("5!")
}
