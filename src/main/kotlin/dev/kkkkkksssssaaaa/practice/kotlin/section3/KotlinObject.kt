package dev.kkkkkksssssaaaa.practice.kotlin.section3

class KotlinObject {

    val person: Person = Person("ㅎㅇ", 1)

    fun doSomething() {
        // companion 에 이름이 없다면 이렇게 접근한다.
        // Person.Companion.newBaby("a")

        // 이름 있는 companion object 는 이렇게 접근한다.
        // Person.Factory.newBaby("a")

        // 싱글톤은 이렇게 사용한다.
        println(Singleton.a)
    }
}

class Person(
    var name: String,
    var age: Int
) {
    // 코틀린은 static 키워드가 없다.
    // 대신 companion object {} 에 요소를 넣어두면 static 처럼 쓸 수 있다.
    // 클래스와 동행한다는 객체라는 뜻에서 companion(동행) 이라는 키워드가 붙은 듯.
    // 얘는 객체로 간주되서, 이름을 붙이거나 인터페이스를 구현하게 할 수도 있다 ㅎㄷ
    companion object Factory: Log {
        // 상수는 이렇게 const 라는 키워드를 붙인다.
        // 얘는 컴파일 시점에 변수가 할당 된다.
        // 기본 타입이나 String 에만 const 키워드를 붙일 수 있다.
        private const val MIN_AGE = 1

        // 이런 어노테이션을 붙이면 Person.newBaby 식으로 직접 접근할 수 있다고 한다.
        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("하이")
        }
    }
}

interface Log {

    fun log()
}

// object 키워드를 선언하면 그냥 싱글톤이 된다고 한다 ㅋ..
object Singleton {
    var a: Int = 0
}

fun doSomething() {

    // (object : 타입이름 {}) 이라는 문법으로 익명 클래스를 사용한다.
    moveSomething(object: Movable {
        override fun move() {
            println("움직인당")
        }

        override fun fly() {
            println("난다요")
        }
    })
}

fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

interface Movable {

    fun move()
    fun fly()
}