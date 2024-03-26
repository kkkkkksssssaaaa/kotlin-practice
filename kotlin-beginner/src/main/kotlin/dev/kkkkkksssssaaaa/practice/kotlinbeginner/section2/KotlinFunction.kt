package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section2

class KotlinFunction {

    fun max(a: Int, b: Int): Int {
        return if (a > b) {
            a
        } else {
            b
        }
    }

    // 이런 문법도 가능하다
    // 이렇게 쓴다
    // max2(1, 2)
    // 함수가 하나의 결과만 반환하면 이렇게 써도 된다고 한다
    // 그럼 여러 개의 결과를 반환한단말인가...? 컬렉션을 말하나..🤔
    fun max2(a: Int, b: Int): Int =
        if (a > b) {
            a
        } else {
            b
        }

    // 타입 생략 가능
    fun max3(a: Int, b: Int) =
        if (a > b) {
            a
        } else {
            b
        }

    // 이런 구문도 가능......🧐
    fun max4(a: Int, b: Int) = if (a > b) a else b

    // 이렇게 써도 되지만 사실 오버로딩도 된다고....
    fun repeat(
        str: String,
        num: Int = 3,
        useNewLine: Boolean = true
    ) {
        for (i in 1..num) {
            if (useNewLine) {
                println(str)
            } else {
                print(str)
            }
        }
    }

    fun printNameAndGender(name: String, gender: String) {
        println(name)
        println(gender)
    }

    // 가변인자는 이런 식으로 선언한다
    fun printAll(vararg strings: String) {
        for (str in strings) {
            println(str)
        }

        val array = arrayOf("A", "B", "C")
        // 가변인자를 넘길 때에는 * 라는 스프레드 연산자를 넣어준다...????
        // 가변인자는 어찌됐단 단건으 데이터를 여러 개 넣을 수 있는 것이니까... 배열의 요소를 하나씩 꺼내서 일일이 넣어준다는 뜻인듯 하다.
        printAll(*array)
    }

    fun doSomething() {
        // named argument
        // 이렇게 기본 값이 존재하는 함수인 경우, 특정 인자에만 값을 지정할 수도 있음
        repeat("hello", useNewLine = true)

        // named argument !!!!!!!
        printNameAndGender(name = "왕해삼", gender = "FEMALE")

        // 자바에서 가져온 함수에는 named argument 를 사용할 수 없다
//        JavaFunction.repeat(str = "왕해삼")
    }
}