package com.github.namhokim.courseleonardo.ex.part1.section1

import kotlinx.coroutines.*

fun main() = runBlocking {
    println(coroutineContext)   // [BlockingCoroutine{Active}@6956de9, BlockingEventLoop@769c9116]
    println(Thread.currentThread().name)
    println ("Hello")
}

