package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StructuredConcurrencyTest {
    @Test
    fun printATest() {
        assertThrows<IllegalArgumentException> {
            StructuredConcurrency().printA()
        }
    }

    @Test
    fun cannotPrintATest() {
        assertThrows<IllegalArgumentException> {
            StructuredConcurrency().cannotPrintA()
        }
    }
}