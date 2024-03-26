package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section4

import dev.kkkkkksssssaaaa.practice.kotlinbeginner.section4.JavaFunction.Person

class KotlinFunction {
}

// 확장함수
class ExtendsFunciton {

    fun doSomething() {
        val train: Train = Train()
        train.isExpensive() // println("Train 의 확장 함수")

        val srt: Srt = Srt()
        srt.isExpensive() // println("Srt 의 확장 함수")

        val fusion: Train = Srt()
        fusion.isExpensive() // println("Train 의 확장 함수")
    }

    // 확장함수
    // String 클래스에 lastChar() 라는 함수를 만들어, String 을 사용하는 곳에 해당 함수를 호출할 수 있게끔 함
    // 다행히도 확장하려는 클래스의 private, protected 요소는 참조할 수 없다.
    // 만약 확장하려는 함수에 동일한 시그니처
    fun String.lastChar(): Char {
        return this[this.length - 1]
    }

    // 시그니처가 동일한 확장함수
    // 이 때 확장함수는 무시되고 멤버함수가 호출된다.
    fun dev.kkkkkksssssaaaa.practice.kotlinbeginner.section4.JavaFunction.Person.nextYearAge(): Int {
        println("확장 함수")

        return this.age + 1
    }

    // 확장 프로퍼티도 있다
    val String.lastChar: Char
        get() = this[this.length - 1]

    open class Train(
        val name: String = "새마을",
        val price: Int = 5_000
    )

    fun Train.isExpensive(): Boolean {
        println("Train 의 확장 함수")
        return this.price >= 10000
    }

    class Srt : Train("STR", 40_000)

    fun Srt.isExpensive(): Boolean {
        println("Srt 의 확장 함수")
        return this.price >= 10000
    }
}

// 중위함수
class InfixFunction {

    fun doSomething() {
        3.add(2)

        // infix 함수는 이렇게 쓸 수 있다.
        3 add2 2
    }

    fun Int.add(other: Int): Int {
        return this + other
    }

    // 중위함수는 인자가 하나여야 한다.
    infix fun Int.add2(other: Int): Int {
        return this + other
    }
}

class InlineFunction {

    fun doSomething() {
        3.add(4)
    }

    // 얘는 함수를 만드는게 아니라 doSomething() 내부에서 아래의 로직이 그대로 inline 으로 구현되는거라 한다.
    // 얘는 좀 신중하게 써야하는 것이 좋고, 성능 개선 목적이 아니면 코틀린이 최적화를 많이 해놔서 굳이 안써도 될듯하다.
    inline fun Int.add(other: Int): Int {
        return this + other
    }
}

class LocalFunction {

    fun createPerson(firstName: String, lastName: String): Person {
        if (firstName.isEmpty()) {
            throw IllegalStateException("firstName 은 비어있을 수 없습니다! 현재 값 : $firstName")
        }

        if (lastName.isEmpty()) {
            throw IllegalStateException("lastName 은 비어있을 수 없습니다! 현재 값 : $lastName")
        }

        fun validateName(name: String, fieldName: String) {
            if (name.isEmpty()) {
                throw IllegalStateException("${fieldName} 은 비어있을 수 없습니다! 현재 값: $name")
            }
        }

        validateName(firstName, "firstName")
        validateName(lastName, "lastName")

        return Person(firstName, lastName, 1)
    }
}