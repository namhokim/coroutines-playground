package com.github.namhokim.courseleonardo.ex.part1.section1

import kotlinx.coroutines.*

fun main() = runBlocking {
    println(this)   // BlockingCoroutine{Active}@52d455b8 : Receiver (수신 객체)
    println(Thread.currentThread().name)
    println ("Hello")
}

