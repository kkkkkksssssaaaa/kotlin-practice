package dev.kkkkkksssssaaaa.practice.kotlin.section4

class KotlinCollection {

    fun doSomething() {
        // 필터링
        fruits.filter {
            it.name == "사과"
        }

        // 필터링 with index
        fruits.filterIndexed { index, fruit ->
            println(index)
            fruit.name == "사과"
        }

        // map
        fruits.filter {
            it.name == "사과"
        }.map {
            it.currentPrice
        }

        // map with index
        fruits.mapIndexed { index, fruit ->
            println(index)
            fruit.currentPrice
        }

        fruits.filter {
            it.name == "사과"
        }.mapNotNull {
            // null 이 아닌 요소만 map 결과에 포함
            // doSomething
        }
    }

    fun doSomething2() {
        // 모든 조건을 만족하면 true, 그렇지 않으면 false
        val isAllApple = fruits.all {
            it.name == "사과"
        }

        // 모든 조건이 false
        val isNoApple = fruits.none {
            it.name == "사과"
        }

        // 하나의 조건이라도 만족
        val anyApple = fruits.any {
            it.factoryPrice >= 10_000
        }

        // 오름차순
        val fruitAsc = fruits.sortedBy {
            it.currentPrice
        }

        // 내림차순
        val fruitDesc = fruitAsc.sortedByDescending {
            it.currentPrice
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

    data class Fruit(
        val id: Long,
        val name: String,
        val factoryPrice: Long,
        val currentPrice: Long
    )
}
