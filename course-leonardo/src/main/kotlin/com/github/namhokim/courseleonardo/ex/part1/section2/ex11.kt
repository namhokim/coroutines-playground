package com.github.namhokim.courseleonardo.ex.part1.section2

import kotlinx.coroutines.*

suspend fun doOneTwoThreeFix() = coroutineScope {   // withContext
    launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1500L)
        println("3!")
    }
    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }
    launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(500L)
        println("2!")
    }
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThreeFix()
    println("runBlocking: ${Thread.currentThread().name}")
    delay(100L)
    println("5!")
}
