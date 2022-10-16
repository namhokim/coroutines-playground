package com.github.namhokim.courseleonardo.ex.part1.section1

import kotlinx.coroutines.*

suspend fun doThree() {
    println("launch1: ${Thread.currentThread().name}")
    delay(1000L)
    println("3!")
}

fun doOne() {
    println("launch2: ${Thread.currentThread().name}")
    println("1!")
}

suspend fun doTwo() {
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)
    println("2!")
}

fun main() {
    runBlocking {
        launch {
            doThree()
        }
        launch {
            doOne()
        }
        doTwo()
    }
    print("4!")
}
