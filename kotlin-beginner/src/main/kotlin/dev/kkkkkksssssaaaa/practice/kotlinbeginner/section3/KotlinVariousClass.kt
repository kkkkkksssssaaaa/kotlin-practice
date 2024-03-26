package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section3

class KotlinVariousClass {

    fun doSomething() {
        val dto1: KotlinDataClass = KotlinDataClass("안녕1", 100)
        val dto2: KotlinDataClass = KotlinDataClass("안녕2", 100)

        println(dto1)
        println(dto2)
    }

    // data class 는 equals, hashCode, toString 을 자동으로 만들어준다.
    data class KotlinDataClass(
        val name: String,
        val age: Int
    )

    enum class KotlinEnum(
        private val code: String
    ) {

        KOREA("KO"),
        AMERICA("US");

        fun handle(kotlinEnum: KotlinEnum) {
            when (kotlinEnum) {
                KOREA -> TODO()
                AMERICA -> TODO()
                // enum 에서는 굳이 else 를 안써도 된다.
                // 심지어 사용하지 않은 enum value 인 경우 IDE 에서 빠졌다고 알려준다;
            }
        }
    }

    // sealed class 는 컴파일 타임에 하위 타입을 모두 기억한다
    // 그리고 런타임에 하위 타입이 추가될 수 없다.
    sealed class KotlinSealedClass(
        val name: String,
        val price: Long
    ) {
        fun handle(car: KotlinSealedClass) {
            // 컴파일 타임에 하위 타입을 모두 기억하기 때문에 enum 과 마찬가지로
            // 모든 case 를 알 수 있기 때문에 else 를 쓰지 않아도 된다.
            when (car) {
                is Avante -> TODO()
                is Grandeur -> TODO()
                is Sonata -> TODO()
            }
        }
    }

    class Avante : KotlinSealedClass("아반뗴", 1_000L)
    class Sonata : KotlinSealedClass("소나타", 2_000L)
    class Grandeur : KotlinSealedClass("그랜저", 3_000L)
}