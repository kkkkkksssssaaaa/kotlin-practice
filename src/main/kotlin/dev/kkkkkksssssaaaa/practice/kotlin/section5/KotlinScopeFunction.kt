package dev.kkkkkksssssaaaa.practice.kotlin.section5

class KotlinScopeFunction {

    fun printPerson(person: Person?) {
        if (person != null) {
            println(person.name)
            println(person.age)
        }
    }

    fun printPerson2(person: Person?) {
        // let 이라는 키워드로 일시정인 영역의 함수를 만들 수 있다.
        // 주로 method chaining 에 사용된다.
        person?.let {
            println(it.name)
            println(it.age)
        }
    }

    class Person(
        val name: String,
        val age: Int
    )
}