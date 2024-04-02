package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import dev.kkkkkksssssaaaa.practice.coroutinebeginner.printWithThread
import kotlinx.coroutines.*
import kotlinx.coroutines.CoroutineScope

class CoroutineContext {
    suspend fun assembleCoroutine() {
        val job = CoroutineScope(Dispatchers.Default).launch {
            delay(1000L)
            printWithThread("Job 1")

            // 덧셈 기호를 통해 코루틴끼리 뭉쳐버릴 수 있다
            coroutineContext + CoroutineName("이름")
        }

        job.join()
    }

    fun customCoroutine() {
        CoroutineName("내꼬") + SupervisorJob()
        CoroutineName("내꼬2") + Dispatchers.Default
    }
}