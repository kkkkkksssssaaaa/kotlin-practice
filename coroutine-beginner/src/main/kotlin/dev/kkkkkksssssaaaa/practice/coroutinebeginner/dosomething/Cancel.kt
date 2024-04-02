package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import kotlinx.coroutines.*

class Cancel {
    fun catchException(): Unit = runBlocking {
        val job = launch {
            try {
                delay(100)
            } catch (e: CancellationException) {

            }

            // catch 로 CancellationException 를 잡아버리면 코루틴이 취소 되지 않는다
            printWithThread("delay 에 의해 취소 되지 않음")
        }

        delay(100)
        printWithThread("취소 시작")
        job.cancel()
    }

    fun throwCancellationException(): Unit = runBlocking {
        // Dispatchers.Default: 메인 스레드와는 별개의 스레드에서 코루틴이 실행 된다.
        val job = launch(Dispatchers.Default) {
            var i = 1
            var nextPrintTime = System.currentTimeMillis()

            // 이 함수는 suspend 처럼 코루틴 함수가 아니기 때문에 실행하게 되면 delay 시간에 상관 없이 5번 모두 실행되어버린다
            while (i <= 5) {
                if (nextPrintTime <= System.currentTimeMillis()) {
                    printWithThread("${i++}번째 출력")
                    nextPrintTime += 1000L
                }

                // dispatchers 옵션 덕분에 delay 는 메인 스레드에서 실행 되고 job 이 다른 스레드에서 실행 되는데,
                // 서로 다른 스레드에서 동작하고 있기 때문에 isActive 를 감지할 수 있게 된다고 한다
                if (!isActive) {
                    throw CancellationException()
                }
            }
        }

        delay(100L)
        job.cancel()
    }

    fun doesNotThrowCancellationException(): Unit = runBlocking {
        val job = launch {
            var i = 1
            var nextPrintTime = System.currentTimeMillis()

            // 이 함수는 suspend 처럼 코루틴 함수가 아니기 때문에 실행하게 되면 delay 시간에 상관 없이 5번 모두 실행되어버린다
            while (i <= 5) {
                if (nextPrintTime <= System.currentTimeMillis()) {
                    printWithThread("${i++}번째 출력")
                    nextPrintTime += 1000L
                }

                // isActive: 코루틴이 활성화 상태인지, 취소 명령을 받았는지 체크하는 변수
                // 다만 delay 함수는 while 이 끝나야 실행 되기 때문에 isActive 가 false 가 될 수는 없다
                if (!isActive) {
                    throw CancellationException()
                }
            }
        }

        delay(100L)
        job.cancel()
    }

    fun infiniteLoop(): Unit = runBlocking {
        val job = launch {
            var i = 1
            var nextPrintTime = System.currentTimeMillis()

            // 이 함수는 suspend 처럼 코루틴 함수가 아니기 때문에 실행하게 되면 delay 시간에 상관 없이 5번 모두 실행되어버린다
            while (i <= 5) {
                if (nextPrintTime <= System.currentTimeMillis()) {
                    printWithThread("${i++}번째 출력")
                    nextPrintTime += 1000L
                }
            }
        }

        delay(100L)
        job.cancel()
    }

    fun doCancel(): Unit = runBlocking {
        val job1 = launch {
            delay(1000L)
            printWithThread("Job1")
        }

        val job2 = launch {
            delay(1000)
            printWithThread("Job2")
        }

        // delay 시간이 100 이라 job1 의 delay 시간인 1초가 되기 전에 job1 이 취소 되어 job2 만 실행 되었다.
        delay(100)
        job1.cancel()
    }

    private fun printWithThread(str: Any) {
        println("[${Thread.currentThread().name} $str]")
    }
}