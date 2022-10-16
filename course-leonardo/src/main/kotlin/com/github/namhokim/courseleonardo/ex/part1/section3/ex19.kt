package com.github.namhokim.courseleonardo.ex.part1.section3

import kotlinx.coroutines.*

suspend fun doOneTwoThree19() = coroutineScope {
    val job1: Job = launch {
        try {
            println("launch1: ${Thread.currentThread().name}")
            delay(1000L)
            println("3!")
        } finally {
            println("job1 is finishing!")
        }
    }

    val job2: Job = launch {
        try {
            println("launch2: ${Thread.currentThread().name}")
            delay(1000L)
            println("1!")
        } finally {
            println("job2 is finishing!")
        }
    }

    val job3: Job = launch {
        try {
            println("launch3: ${Thread.currentThread().name}")
            delay(1000L)
            println("2!")
        } finally {
            println("job3 is finishing!")
        }
    }

    delay(800L)
    job1.cancel()
    job2.cancel()
    job3.cancel()
    joinAll(job1, job2, job3)
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree19()
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}
