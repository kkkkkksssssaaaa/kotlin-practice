package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import org.junit.jupiter.api.Test

class CoroutineBuilderTest {
    @Test
    fun doTest() {
        CoroutineBuilder().main()
    }

    @Test
    fun launchTest() {
        CoroutineBuilder().launch()
    }

    @Test
    fun launch2Test() {
        CoroutineBuilder().launch2()
    }

    @Test
    fun launch3Test() {
        CoroutineBuilder().launch3()
    }

    @Test
    fun asyncTest() {
        CoroutineBuilder().asyncJob()
    }

    @Test
    fun apiCallTest() {
        CoroutineBuilder().apiCall()
    }

    @Test
    fun apiCall2Test() {
        CoroutineBuilder().apiCall2()
    }
}