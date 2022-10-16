package com.github.namhokim.courseleonardo.ex.part1.section1

import kotlinx.coroutines.*

fun main() = runBlocking {    // runBlocking(context = Dispatchers.IO) { // DefaultDispatcher-worker-1
    println(Thread.currentThread().name)    // main 만 찍힘? @coroutine1 는 안 찍힘
    println ("Hello")
}
