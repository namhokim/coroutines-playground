package com.github.namhokim.courseleonardo.ex

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {    // vs launch(context = Dispatchers.IO) {
        println("launch: ${Thread.currentThread().name}")   // 3
        println("World!")                                   // 4
    }
    println("runBlocking: ${Thread.currentThread().name}")  // 1
    println("Hello")                                        // 2
}

