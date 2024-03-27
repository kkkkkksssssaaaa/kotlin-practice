package dev.kkkkkksssssaaaa.practice.coroutinebeginner.blocking

import kotlinx.coroutines.*

class ExceptionHandling {
    // exceptionHandler 는 부모 코루틴이 있으면 동작 하지 않는다. 즉, 루트여야만 동작한다.
    fun coroutineExceptionHandler(): Unit = runBlocking {
        val ex = CoroutineExceptionHandler { _, throwable ->
            printWithThread("예외")
            throw throwable
        }

        val job = CoroutineScope(Dispatchers.Default).launch(ex) {
            throw IllegalArgumentException()
        }

        delay(1000)
    }

    // 자식 코루틴의 예외가 부모까지 전파되지 않게 하려면 SupervisorJob 을 사용하면 된다
    // 부모-자식 관계는 유지 되지만 예외는 전파하지 않는다고 한다. 다만 await() 을 사용하면 예외는 터진다.
    fun useSupervisorJob(): Unit = runBlocking {
        val job = async(SupervisorJob()) {
            throw IllegalArgumentException()
        }

        delay(1000)
    }

    // async 가 자식 코루틴일 때에는 예외를 바로 던져버린다
    // 자식 코루틴의 예외는 부모 코루틴에 전파된다
    fun useAsyncChild(): Unit = runBlocking {
        val job = async {
            throw IllegalArgumentException()
        }

        delay(1000)
    }

    // async 를 사용하면 launch {} 와는 다르게 예욀르 던지지 않는다.
    // await() 을 사용하면 예욀르 던진다.
    fun useAsync(): Unit = runBlocking {
        val job = CoroutineScope(Dispatchers.Default).async {
            throw IllegalArgumentException()
        }

        job.await()
        delay(1000)
    }

    // 시작하자마자 예외를 던진다ㅠ
    fun exception(): Unit = runBlocking {
        val job = CoroutineScope(Dispatchers.Default).launch {
            throw IllegalArgumentException()
        }

        delay(1000)
    }

    fun createNewRoot(): Unit = runBlocking {
        // 새 코루틴을 별도의 스레드에서 생성하는 함수
        // 이렇게 되면 tree() 와는 다르게 모든 코루틴이 root 가 된다.
        val job1 = CoroutineScope(Dispatchers.Default).launch {
            delay(1000)
            printWithThread("Job1")
        }

        val job2 = CoroutineScope(Dispatchers.Default).launch {
            delay(1000)
            printWithThread("Job2")
        }
    }

    // 이 코루틴은 runBlocking 이라는 부모 코루틴에 job1, job2 라는 자식 코루틴이 존재하는 형태이다.
    fun tree(): Unit = runBlocking {
        val job1 = launch {
            delay(1000)
            printWithThread("Job1")
        }

        val job2 = launch {
            delay(1000)
            printWithThread("Job2")
        }
    }

    private fun printWithThread(str: Any) {
        println("[${Thread.currentThread().name} $str]")
    }
}