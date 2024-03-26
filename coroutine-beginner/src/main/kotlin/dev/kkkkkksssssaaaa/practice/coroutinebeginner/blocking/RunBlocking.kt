package dev.kkkkkksssssaaaa.practice.coroutinebeginner.blocking

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

class RunBlocking {
    // runBlocking: 일반 루틴(함수) 를 새 코루틴으로 만들어준다.
    // 이 함수는 runBlocking 과 launch 에 의해 두 개의 코루틴을 실행하는 함수가 된다.
    /*
    실행 결과

    [Test worker @coroutine#1 START]
    [Test worker @coroutine#1 END]
    [Test worker @coroutine#2 3]

    이유: yield() 가 main() 과 newRoutine() 에 존재 하는데,
    이 때문에 main() 함수가 실행 되면서 println("START") 를 수행하게 되고,
    코루틴인 newRoutine() 이 호출되면서 num1 과 num2 를 선언하게 된다.
    이 때 newRoutine() 에 존재하는 yield() 구문 때문에
    newRoutine() 의 실행이 잠시 중단 되고 main() 으로 돌아와 println("END") 를 수행한다.
    코루틴인 main() 이 종료 되었기 때문에, 대기 중이던 newRoutine() 이 다시 수행 되며 println("${num1 + num2}") 를 수행하며
    최종적으로는 위와 같은 결과가 출력 된다.
     */
    fun main(): Unit = runBlocking {
        printWithThread("START")

        // launch: 반환값이 없는 코루틴을 만드는 함수
        launch {
            newRoutine()
        }

        // 얘는 suspend function 이다
        // 지금 실행 중인 코루틴을 중단하고 다른 코루틴이 실행 되도록 한다.
        // 즉, 스레드 점유를 양보한다
        yield()

        printWithThread("END")
    }

    suspend fun newRoutine() {
        val num1 = 1
        val num2 = 2

        yield()

        printWithThread("${num1 + num2}")
    }

    private fun printWithThread(str: Any) {
        println("[${Thread.currentThread().name} $str]")
    }
}