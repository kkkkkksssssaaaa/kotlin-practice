package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import dev.kkkkkksssssaaaa.practice.coroutinebeginner.printWithThread
import kotlinx.coroutines.*
import kotlinx.coroutines.CoroutineScope

class CoroutineScope {
    suspend fun runDirectlyWithJoin(): Unit {
        val job = CoroutineScope(Dispatchers.Default).launch {
            delay(1_000L)
            printWithThread("Job 1")
        }

        job.join()
    }

    fun runDirectly(): Unit {
        CoroutineScope(Dispatchers.Default).launch {
            delay(1_000L)
            printWithThread("Job 1")
        }

        Thread.sleep(1_500L)
    }
}

class AsyncLogic {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun doSomething() {
        scope.launch {
            printWithThread("run AsyncLogic.doSomething")
        }
    }

    fun destroy() {
        scope.cancel()
    }
}