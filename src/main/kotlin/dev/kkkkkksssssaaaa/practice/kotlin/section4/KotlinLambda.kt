package dev.kkkkkksssssaaaa.practice.kotlin.section4

class KotlinLambda {

    fun doSomething() {
        // 익명 함수
        val isApple = fun(fruit: Fruit): Boolean {
            return fruit.name == "사과"
        }

        // 이렇게 표기해도 된다.
        val isAppleWithReturnType: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
            return fruit.name == "사과"
        }

        isApple(fruits[0])

        // 익명 함수2
        val isApple2 = { fruit: Fruit -> fruit.name == "사과" }
        val isApple2WithReturnType: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

        isApple2(fruits[0])
        filterFruits(fruits, isApple)

        // 함수의 마지막 인자가 함수인 경우 이렇게 매개변수에서 생략한 뒤에 간단하게 함수 몸체를 구현하는 방식으로 사용할 수 있음
        filterFruits(fruits) {
            fruit: Fruit -> fruit.name == "사과"
        }

        filterFruits(fruits) {
            // 함수의 인자가 한 개이면 it 이라는 키워드를 사용할 수 있다.
            it.name == "사과"
        }
    }

    // 함수를 파라미터로 받을 수 있다.
    fun filterFruits(
        fruits: List<Fruit>,
        filter: (Fruit) -> Boolean
    ): List<Fruit> {
        val results = mutableListOf<Fruit>()

        for (fruit in fruits) {
            if (filter(fruit)) {
                results.add(fruit)
            }
        }

        return results;
    }

    class Fruit(
        val name: String,
        val price: Long
    )

    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000)
    )
}

