package com.github.namhokim.courseleonardo.ex.part1.section7

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlin.system.measureTimeMillis

private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val elapsed = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                repeat(k) {
                    action()
                }
            }
        }
    }
    println("$elapsed ms 동안 ${n * k}개의 연산을 수행")
}

@ObsoleteCoroutinesApi
fun main() = runBlocking<Unit> {
    val counter: SendChannel<CounterMsg> = counterActor()
    withContext(Dispatchers.Default) {
        massiveRun {
            counter.send(IntCounter)
        }
    }
    val response: CompletableDeferred<Int> = CompletableDeferred()
    counter.send(GetCounter(response))
    println("Counter = ${response.await()}")
    counter.close()
}

sealed class CounterMsg
object IntCounter : CounterMsg()
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()

@ObsoleteCoroutinesApi
fun CoroutineScope.counterActor() = actor<CounterMsg> {
    var counter = 0

    for (msg: CounterMsg in channel) {
        when (msg) {
            is IntCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
}
