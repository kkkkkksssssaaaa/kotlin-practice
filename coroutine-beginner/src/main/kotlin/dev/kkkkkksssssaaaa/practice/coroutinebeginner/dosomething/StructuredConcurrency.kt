package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class StructuredConcurrency {
    // A 가 출력되지 않고 예외가 터진다
    fun cannotPrintA(): Unit = runBlocking {
        launch {
            delay(600L)
            printWithThread("A")
        }

        launch {
            delay(500L)
            throw IllegalArgumentException("코루틴 실패")
        }
    }

    // A 가 출력되고 예외가 터진다
    // 부모 코루틴
    fun printA(): Unit = runBlocking {
        // 자식 코루틴
        launch {
            delay(500L)
            printWithThread("A")
        }

        // 자식 코루틴
        launch {
            delay(600L)
            throw IllegalArgumentException("코루틴 실패")
        }
    }

    private fun printWithThread(str: Any) {
        println("[${Thread.currentThread().name} $str]")
    }
}