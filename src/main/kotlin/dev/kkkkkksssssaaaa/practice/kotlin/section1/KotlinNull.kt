package dev.kkkkkksssssaaaa.practice.kotlin.section1

import dev.kkkkkksssssaaaa.practice.kotlin.common.Person

class KotlinNull {

    fun doSomething() {
        // Safe Call
        val str: String? = "ABC"
//        str.length, 실행이 불가능하다
        str?.length // null 이면 실행하지 않는다
    }

    fun runElvisOperator() {
        val nullString: String? = null
        println(nullString?.length)
        println(nullString?.length ?: 0)
    }

    fun useJavaClass() {
        val person = Person("안녕")
//        startsWith(person.nullableName) : 자바 클래스의 어노테이션 정보를 참조하여, nullable 이면 컴파일 에러가 발생한다.
        startsWith(person.notNullName)
        startsWith(person.name) // 어노테이션 정보가 없다면 컴파일 에러는 없다.
    }

    // 매개변수가 null 일 수 있다면, 해당 매개변수를 바로 사용할 수 없다.
    fun startsWithA1(str: String?): Boolean {
        return str?.startsWith("A") ?: throw IllegalStateException("null")
    }

    fun startsWithA2(str: String?): Boolean? {
        return str?.startsWith("A")
    }

    fun startsWithA3(str: String?): Boolean {
        str ?: return false

        return str.startsWith("A")
    }

    fun startsWithA4(str: String?): Boolean {
        // 해당 변수가 절대 null 이 아님을 단언함
        return str!!.startsWith("A")
    }

    fun startsWith(str: String): Boolean {
        return str.startsWith("A")
    }
}