package dev.kkkkkksssssaaaa.practice.coroutinebeginner.dosomething

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Test

class ContinuationTest {
    @Test
    fun findUserTest() {
        CoroutineScope(Dispatchers.Default).launch {
            println("userService.findUser=${UserService().findUser(1L)}")
        }
    }
}