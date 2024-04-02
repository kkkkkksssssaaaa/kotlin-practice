package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import dev.kkkkkksssssaaaa.practice.coroutinebeginner.printWithThread
import kotlinx.coroutines.*
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.Executors

class CoroutineDispatcher {
    fun executorToCoroutine() {
        CoroutineName("하이") + Dispatchers.Default

        val threadPool = Executors.newSingleThreadExecutor()

        CoroutineScope(threadPool.asCoroutineDispatcher()).launch {
            printWithThread("뉴 코루틴")
        }
    }
}