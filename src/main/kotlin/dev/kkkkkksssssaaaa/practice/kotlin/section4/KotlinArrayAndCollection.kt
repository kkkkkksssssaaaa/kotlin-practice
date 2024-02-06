package dev.kkkkkksssssaaaa.practice.kotlin.section4

class KotlinArrayAndCollection {

    fun doSomething() {
        val array: Array<Int> = arrayOf(100, 200)

        for (i in array.indices) {
           println("$i $array[i]")
        }

        for ((i, value) in array.withIndex()) {
            println("$i $value")
        }

        // 이렇게 간단하게 추가할 수 있다.
        array.plus(300)

        val numbers: List<Int> = listOf(100, 200)
        // empty list 의 경우 타입을 명시해주어야 한다.
        // 다만 추론이 가능하다면 생략 해도 된다.
        val emptyList = emptyList<Int>()
    }

    fun doSomething2() {
        // 이렇게만 해도 불변 리스트가 된다.
        val numbers: List<Int> = listOf(100, 200)

        // set 은 요렇게 선언한다.
        // 기본적으로는 linkedHashSet 을 사용한다.
        val numbersSet: Set<Int> = setOf(100, 200)

        // map 은 이렇게 쓴다. Map 과 MutableMap 은 다르니 주의하자.
        val numbersMap: MutableMap<Int, String> = mutableMapOf()
        // 이렇게 넣거나
        numbersMap.put(1, "Monday")
        // 이렇게 넣는다.
        numbersMap[2] = "Tuesday"

        // 오 이렇게 해도 됨
        val newNumbersMap: Map<Int, String> = mapOf(1 to "Monday", 2 to "Tuesday")

        // 가변 리스트는 이렇게 정의하면 된다.
        val mutableNumbers: List<Int> = mutableListOf(100, 200)
        mutableNumbers.plus(100)

        // list 도 이렇게 접근 가능하다.
        println(numbers[0])

        for (number in numbers) {
            println(number)
        }

        for ((i, value) in numbers.withIndex()) {
            println("$i $value")
        }

        for (key in numbersMap.keys) {
            println(key)
            println(numbersMap[key])
        }

        for ((key, value) in numbersMap.entries) {
            println(key)
            println(value)
        }

        // List<Int?> : 리스트에 null 이 들어갈 수 있으나 List 는 not null
        // List<Int>? : 리스트의 요소는 not null 이나, List 가 nullable
        // List<Int?>? : 리스트와 요소 모두 nullable
        // 뭐 이러한 특징들 때문에 자바와 코틀린에서 동시에 같은 컬렉션을 다룬다면 혼동이 초래될 수 있다.
        // 자바의 모든 참조형은 null 일 수 있으니까...
        // 굳이 자바와 코틀린에서 모두 사용하곘다면, 자바에도 제공하는 함수인 Collectors.unmodifiable() 을 코틀린에서 사용하여 자바에게 반환해줘라.
    }
}

class KotlinCollection(

) {

}