package com.github.namhokim.courseleonardo.ex.part1.section1

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }
    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)
    println("2!")
}
