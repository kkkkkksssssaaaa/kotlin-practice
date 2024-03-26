package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section1

import dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person

class KotlinType {

    fun doSomething() {
        val number1: Int = 4
//        val number2: Long = number1 : 코틀린은 암시적 타입 변환이 불가능하다.
        val number2: Long = number1.toLong()

        println(number1 + number2)
    }

     fun doSomething2() {
         val number1: Int? = 3
         val number2: Long = number1?.toLong() ?: 0L
     }

    fun doSomething3(obj: Any) {
        if (obj is dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person) {
            // 이렇게 쓸 수도 있고
            val person: dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person = obj as dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person
            println(person.age)

            // 타입 검증이 완료 되었다면 바로 사용할 수도 있음
            println(obj.age)
        }

        if (obj !is dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person) {
            println()
        }
    }

    fun doSomething4(obj: Any?) {
        // nullable 인 경우에는 as 에 ? 를 붙인다
        val person = obj as? dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person
        println(person?.age)
    }

    fun doSomething5() {
        val person = dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person("승아", 3)
        val name = "승아"

        println("이름 ${person.name}")
        println("이름 $name")

        println(
            """
                하이하이
                안녕안영
                홀로로
                ${name}
            """.trimIndent()
        )

        println("이름 ${name[1]}")
    }
}