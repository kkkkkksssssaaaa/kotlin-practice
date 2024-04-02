package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import org.junit.jupiter.api.Test

class CancelTest {
    @Test
    fun doTest() {
        Cancel().doCancel()
    }

    @Test
    fun infiniteLoopTest() {
        Cancel().infiniteLoop()
    }

    @Test
    fun doesNotThrowCancellationExceptionTest() {
        Cancel().doesNotThrowCancellationException()
    }

    @Test
    fun throwCancellationExceptionTest() {
        Cancel().throwCancellationException()
    }

    @Test
    fun catchExceptionTest() {
        Cancel().catchException()
    }
}