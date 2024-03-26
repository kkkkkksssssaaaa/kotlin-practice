package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section3

class KotlinNestedClass {
}

class KotlinHouse(
    private val address: String,
    private val livingRoom: LivingRoom
) {

    // static class 로 만들어진다.
    class LivingRoom(
        private val area: Double
    )

    // 일반적인 class 로 만들어진다. 상위 클래스에 대한 참조 정보를 가지고 있기 때문에 권장 되지 않는다.
    inner class InnerLivingRoom(
        private val area: Double
    ) {
        val address: String
            // 상위 클래스를 참조하려면 @ 를 붙인다.
            get() = this@KotlinHouse.address
    }
}