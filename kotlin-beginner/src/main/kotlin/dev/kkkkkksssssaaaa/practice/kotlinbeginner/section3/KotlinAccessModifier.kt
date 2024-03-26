package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section3

class KotlinAccessModifier {
}

// 코틀린은 변수나 함수를 클래스 안에 정의하지 않고 이렇게 정의하는 것도 가능하다.
// 이런 방식은 유틸 함수를 정이ㅡ하는 데에 아주 용이
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}

val car1: Car = Car("1", "2", 3)

class Car(
    private val name: String,
    internal var owner: String,
    _price: Int
) {
    var price = _price
        // 이런 구문으로 setter 를 private 으로 만들 수 있음
        private set
}

