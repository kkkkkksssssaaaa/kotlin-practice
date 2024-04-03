package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething.CoroutineScope
import dev.kkkkkksssssaaaa.practice.coroutinebeginner.printWithThread
import kotlinx.coroutines.*
import kotlinx.coroutines.time.withTimeout

class SuspendingFunction {
    fun useWithTimeoutOrNull() = runBlocking {
        withTimeoutOrNull(1000L) {
            delay(1500)
            10 + 20
        }
    }

    fun useWithTimeout() = runBlocking {
        withTimeout(1000L) {
            delay(1500)
            10 + 20
        }
    }

    suspend fun useWithContext() = withContext(Dispatchers.Default) {
        val num1 = async {
            delay(1000)
            10
        }

        val num2 = async {
            delay(1000)
            20
        }

        num1.await() + num2.await()
    }

    fun coroutineScope() = runBlocking {
        printWithThread("START")
        printWithThread(calculateResult())
        printWithThread("END")
    }

    suspend fun calculateResult(): Int = coroutineScope {
        val num1 = async {
            delay(1000)
            10
        }

        val num2 = async {
            delay(1000)
            20
        }

        num1.await() + num2.await()
    }

    interface AsyncCaller {
        suspend fun call()
    }

    class AsyncCallerImpl: AsyncCaller {
        // 인터페이스에 정의된 시그니처에 suspend 가 포함 되어 있다면 구현체에서도 suspend 를 포함해야 한다
        override suspend fun call() {
            TODO("Not yet implemented")
        }
    }

    fun asyncFunctionWithSuspend(): Unit = runBlocking {
        val result1 = suspendCall1()
        val result2 = suspendCall2(result1)

        printWithThread(result2)
    }

    fun asyncFunction(): Unit = runBlocking {
        val result1: Deferred<Int> = async {
            call1()
        }

        val result2 = async {
            call2(result1.await())
        }

        printWithThread(result2.await())
    }

    fun call1(): Int {
        Thread.sleep(1000L)
        return 100
    }

    fun call2(num: Int): Int {
        Thread.sleep(1000L)
        return num * 2
    }

    suspend fun suspendCall1(): Int {
        return CoroutineScope(Dispatchers.Default).async {
            Thread.sleep(1000L)
            100
        }.await()
    }

    suspend fun suspendCall2(num: Int): Int {
        return CoroutineScope(Dispatchers.Default).async {
            Thread.sleep(1000L)
            num * 2
        }.await()
    }

    fun ex1(): Unit = runBlocking {
        launch {
            a()
            b()
        }

        launch {
            c()
        }
    }

    suspend fun a() {
        printWithThread("A")
    }

    suspend fun b() {
        printWithThread("B")
    }

    suspend fun c() {
        printWithThread("C")
    }
}