package dev.kkkkkksssssaaaa.practice.kotlin.section1

fun doSomething() {
    // 가변
    var number = 10L

    // 불변
    val number2: Long = 10L

    // 불변이지만 초기화 되지 않은 변수인 경우 최초 한 번은 값을 할당해줄 수 있다
    val number3: Long
    number3 = 3L

    // null 을 넣어야 한다면 타입을 선언하고 ? 를 붙여준다
    var number4: Long? = 1_000L
    number4 = null

    var person = Person("왕해삼")
}

class Person(val name: String) {

}