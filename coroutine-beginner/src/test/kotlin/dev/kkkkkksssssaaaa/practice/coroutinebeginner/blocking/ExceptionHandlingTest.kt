package dev.kkkkkksssssaaaa.practice.coroutinebeginner.blocking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionHandlingTest {
    @Test
    fun exceptionTest() {
        assertDoesNotThrow {
            ExceptionHandling().exception()
        }
    }

    @Test
    fun useAsyncTest() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandling().useAsync()
        }
    }

    @Test
    fun useAsyncChildTest() {
        assertThrows<IllegalArgumentException> {
            ExceptionHandling().useAsyncChild()
        }
    }

    @Test
    fun useSupervisorJobTest() {
        assertDoesNotThrow {
            ExceptionHandling().useSupervisorJob()
        }
    }

    @Test
    fun coroutineExceptionHandlerTest() {
        assertDoesNotThrow {
            ExceptionHandling().coroutineExceptionHandler()
        }
    }
}