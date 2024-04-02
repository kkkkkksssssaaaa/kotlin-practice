package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CoroutineBuilder {
    // runBlocking 같은 코루틴 생성 함수를 코루틴 빌더라고 한다
    /**
     * 출력 결과
     *
     * [Test worker @coroutine#1 START]
     * [Test worker @coroutine#1 END]
     * # wait 2 seconds
     * [Test worker @coroutine#2 LAUNCH END]
     * */
    fun main(): Unit = runBlocking {
        printWithThread("START")

        launch {
            // 특정 시간만큼 동작을 정지한다
            delay(2_000L)
            printWithThread("LAUNCH END")
        }

        printWithThread("END")
    }

    fun launch(): Unit = runBlocking {
        // start = CoroutineStart.LAZY 옵션을 주면 코루틴을 시작하는 함수를 수동으로 호출해야만 실제로 실행 된다
        val job = launch(start = CoroutineStart.LAZY) {
            printWithThread("Hello Launch")
        }

        delay(1_000L)
        job.start()
    }

    /**
     * 출력 결과
     *
     * [Test worker @coroutine#2 1]
     * [Test worker @coroutine#2 2]
     * */
    fun launch2(): Unit = runBlocking {
        val job = launch {
            (1..5).forEach {
                printWithThread(it)
                delay(500)
            }
        }

        delay(1_000L)
        job.cancel()
    }

    fun launch3(): Unit = runBlocking {
        val job1 = launch {
            delay(1_000L)
            printWithThread("Job1")
        }

        // join() 을 사용하면 해당 코루틴이 완전히 종료 되기 전 까지 다른 코루틴을 실행하지 않는다.
        // join() 을 사용하지 않으면 job1 이 먼저 실행 되고 그 다음 job2 가 수 ms 내에 실행된다. 전체 함수 실행 시간은 약 1 sec 100 ms 정도가 된다.
        job1.join()

        val job2 = launch {
            delay(1_000L)
            printWithThread("Job2")
        }
    }

    fun asyncJob(): Unit = runBlocking {
        // async 는 코루틴을 실행한 뒤 결과를 반환 받는 코루틴 빌더이다.
        val job = async {
            3 + 5
        }

        // await() 은 async 의 결과를 가져오는 함수이다.
        val result: Int = job.await()

        printWithThread(result)
    }

    fun apiCall() = runBlocking {
        val time = measureTimeMillis {
            // async 와 await 키워드를 함께 사용할 때, CoroutineStart.LAZY 옵션을 함께 사용하면
            // await() 함수를 호출했을 때 계산 결과를 계속 기다린다.
            val job1 = async {
                return1()
            }

            val job2 = async {
                return2()
            }

            printWithThread(job2.await())
        }

        printWithThread("소요 시간 : $time ms")
    }

    fun apiCall2() = runBlocking {
        val time = measureTimeMillis {
            // async 와 await 키워드를 함께 사용할 때, CoroutineStart.LAZY 옵션을 함께 사용하면
            // await() 함수를 호출했을 때 계산 결과를 계속 기다린다.
            // 대신 start() 함수를 호출해주면 괜찮다.
            val job1 = async(start = CoroutineStart.LAZY) {
                return1()
            }

            val job2 = async {
                return2PlusNum(job1.await())
            }

            printWithThread(job2.await())
        }

        printWithThread("소요 시간 : $time ms")
    }

    suspend fun return1(): Int {
        delay(1_000L)
        return 1
    }

    suspend fun return2(): Int {
        delay(1_000L)
        return 2
    }

    suspend fun return2PlusNum(num: Int): Int {
        delay(1_000L)
        return 2 + num
    }

    private fun printWithThread(str: Any) {
        println("[${Thread.currentThread().name} $str]")
    }
}