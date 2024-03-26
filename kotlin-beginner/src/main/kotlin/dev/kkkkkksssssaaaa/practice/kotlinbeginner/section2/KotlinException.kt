package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section2

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class KotlinException {

    fun doSomething(str: String): Int {
        try {
            return str.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalStateException("주어진 숫자 ${str}은 숫자가 아닙니다.")
        }
    }

    fun doSomething2(str: String): Int? {
        // 전통적으로 쓸 수도 있지만
//        try {
//            return str.toInt()
//        } catch (e: NumberFormatException) {
//            return null
//        }

        // 코틀린에서는 try-catch 문도 Expression 으로 간주 되기 때문에 바로 return 할 수 있다.
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    // 코틀린은 모두 UncheckedException 이다.
    fun doSomething3() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")

        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())

        reader.close()
    }

    fun doSomething4(path: String) {
        // try-with-resources 가 사라지고 확장 함수인 use 를 사용한다.
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}