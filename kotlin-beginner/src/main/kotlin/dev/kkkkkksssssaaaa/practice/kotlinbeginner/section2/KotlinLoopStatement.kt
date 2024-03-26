package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section2

class KotlinLoopStatement {

    fun doSomething() {
        val numbers = listOf(1L, 2L, 3L)

        for (n in numbers) {
            println(n)
        }

        for (i in 1..3) {
            println(i)
        }

        for (i in 3 downTo 1) {
            println(i)
        }

        for (i in 1..5 step 2) {
            println(i)
        }

        // while, do-while 은 자바랑 똑같음
    }
}