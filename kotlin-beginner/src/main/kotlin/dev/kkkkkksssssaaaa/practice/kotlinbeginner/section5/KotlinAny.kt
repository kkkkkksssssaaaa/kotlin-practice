package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section5

// 1. type alias 와 as import
// 이런식으로 특정 타입에 별칭을 붙일 수 있음.
typealias FruitFilter = (KotlinAny.Fruit) -> Boolean

class KotlinAny {

    fun doSomething() {
        // 구조 분해
        // 복합적인 값을 분해하여 여러 변수를 한 번에 초기화하는 것
        val person = Person("승", 100)
        // 변수 여러개 선언하는 거..
        // 타입스크립트의 그 것과 비슷하다.
        // data class 는 기본적으로 필드마다 componentN 이라는 함수를 구현해주는데, 이 함수로 인해 구조분해가 가능하다고...
        // data class 가 아닐 때에도 구조분해를 사용하고 싶다면, 해당 클래스에 componentN 을 직접 구현해도 된다.
        val (name, age) = person

        // 이렇게 쓰면 break 문 같은 거라고..
        run {
            fruits.forEach { fruit ->
                if (fruit.currentPrice > 1_00) {
                    return@run
                }
            }
        }

        // 이건 continue 같은 거라고......
        fruits.forEach { fruit ->
            if (fruit.currentPrice > 1_00) {
                return@forEach
            }
        }

        // 특정 expression 에 별명을 붙일 수 있다.
        loof@ for (i in 1..100) {
            for (j in 1..100) {
                if (j == 2) {
                    // 이렇게 하면 i 로 반복하는 for 문이 break 된다고 ㅎㄷ
                    break@loof
                }

                println("${i} ${j}")
            }
        }

        // takeif 와 takeuneless
        // 이렇게 쓸 수도 있지만
        fun getNumberOrNull(): Fruit? {
            return if (apple.currentPrice > 1 ) {
                return null
            } else {
                return apple
            }
        }

        // 이렇게 축약해서도 쓸 수 있다.
        // 조건에 만족하지 않으면 null 을 반환한다.
        fun getNumberOrNull2(): Fruit? {
            return apple.takeIf { it.currentPrice > 1 }
        }

        // 얘는 takeIf 와 반대로 조건에 맞으면 null 을 반환한다.
        fun getNumberOrNull3(): Fruit? {
            return apple.takeUnless { it.currentPrice > 1 }
        }
    }

    val fruits = listOf(
        Fruit(1, "사과", 1_000, 1_000),
        Fruit(2, "사과", 1_200, 1_200),
        Fruit(3, "사과", 1_200, 1_200),
        Fruit(4, "사과", 1_500, 1_500),
        Fruit(5, "바나나", 3_000, 3_000),
        Fruit(6, "바나나", 3_200, 3_200),
        Fruit(7, "바나나", 2_500, 2_500),
        Fruit(8, "수박", 10_000, 10_000)
    )

    val apple: Fruit = Fruit(1, "사과", 1_000, 1_000)

    data class Fruit(
        val id: Long,
        val name: String,
        val factoryPrice: Long,
        val currentPrice: Long
    )

    data class Person(
        val name: String,
        val age: Int
    )

    class NormalPerson(
        val name: String,
        val age: Int
    ) {
        // 이렇게 component...N 를 직접 구현하면 구조분해가 가능하다.
        operator fun component1(): String {
            return this.name
        }

        operator fun component2(): Int {
            return this.age
        }
    }
}