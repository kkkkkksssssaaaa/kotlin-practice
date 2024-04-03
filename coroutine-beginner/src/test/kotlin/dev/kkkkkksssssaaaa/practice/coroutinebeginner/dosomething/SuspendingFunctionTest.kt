package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SuspendingFunctionTest {
    @Test
    fun ex1Test() {
        SuspendingFunction().ex1()
    }

    @Test
    fun asyncFunctionTest() {
        SuspendingFunction().asyncFunction()
    }

    @Test
    fun asyncFunctionWithSuspendTest() {
        SuspendingFunction().asyncFunctionWithSuspend()
    }

    @Test
    fun coroutineScopeTest() {
        SuspendingFunction().coroutineScope()
    }

    @Test
    fun useWithContextTest() {
        CoroutineScope(Dispatchers.Default).launch {
            SuspendingFunction().useWithContext()
        }
    }

    @Test
    fun useWithTimeoutTest() {
        assertThrows<TimeoutCancellationException> {
            SuspendingFunction().useWithTimeout()
        }
    }

    @Test
    fun useWithTimeoutOrNullTest() {
        assertNull(SuspendingFunction().useWithTimeoutOrNull())
    }
}