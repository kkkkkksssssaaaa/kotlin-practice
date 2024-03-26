package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section3

import dev.kkkkkksssssaaaa.practice.kotlinbeginner.section3.JavaClass.Javaperson

class KotlinClass {

    fun doSomething() {
        val javaPerson: Javaperson = Javaperson("승", 10)
        println(javaPerson.name)
        javaPerson.age = 1
        println(javaPerson.age)
    }

    // 이렇게 constructor 키워드를 명시할 수도 있고
//    class KotlinPerson constructor(name: String, age: Int) {
//
//        val name: String = name
//        var age: Int = age
//    }

    // constructor 키워드를 지울 수도 있다
//    class KotlinPerson(name: String, age: Int) {
//
//        val name: String = name
//        var age: Int = age
//    }

    // 중활호 없이 이렇게 만들 수도 있다.
    // 코틀린은 기본적으로 getter, setter 를 자동으로 만들어 준다.
//    class KotlinPerson(val name: String, var age: Int)

    // 주 생성자는 이렇게 만든다.
    class KotlinPerson(
        var name: String = "홍길동",
        var age: Int = 1
    ) {
        // 필드의 custom getter
//        var name: String = name
//            get() = field.uppercase()
//            // custom setter 는 이렇게 만든다.
//            set(value) {
//                field = value.uppercase()
//            }

        // 하지만 필드에 대한 custom getter 를 사용하기 보다는, 요구사항에 맞는 메서드 or custom getter 를 만드는게 더 나을지도...
        val upperCaseName: String
            get() = this.name.uppercase()

        val isAdult: Boolean
            // 코틀린이 자동으로 만들어주는 getter 는 요런 식으로도 정의할 수 있다.
            get() = this.age >= 20

        // 얘는 생성자가 호출되는 시점에 호출 된다.
        // 그냥 생성자 내에 로직을 정의할 때 사용할 수 있는듯.
        init {
            if (age <= 0) {
                throw IllegalStateException("나이는 ${age}일 수 없습니다.")
            }
        }

        // 생성자 오버로드는 이렇게 한다.
        // 하지만, 코틀린에서는 생성자를 여러 개 사용하기 보다는 생성자에 기본값을 지정하는 것을 추천한다고 한다.
        // 그럼에도 불구하고 생성자 오버로드가 필요하다면... 정적 팩토리 메서드를 써라.
        constructor(name: String): this(name, 1) {
            println("부생성자1")
        }

        constructor(): this("홍길동") {
            println("부생성자2")
        }

        fun isAudult(): Boolean {
            return this.age >= 20
        }
    }
}
