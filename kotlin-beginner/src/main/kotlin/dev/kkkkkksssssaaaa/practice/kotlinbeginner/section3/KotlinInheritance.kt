package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section3

class KotlinInheritance {

    abstract class KotlinAnimal(
        protected val species: String,
        // 자식 클래스에서 이 프로퍼티를 override 하려면 open 이라는 키워드를 붙여주어야 한다.
        // 뭔가 코틀린이 만들어주는 프로퍼티의 getter 는 final 이 선언되었다....... 정도로 이해하면 될듯
        // 이 open 이라는 키워드는 클래스 레벨에도 선언이 가능한데, open class 라는 뜻은 상속이 가능한 클래스라는 뜻이다.
        protected open val legCount: Int
    ) {

        abstract fun move()
    }

    class KotlinCat(
        species: String
    ) : KotlinAnimal(species, 4) {

        // override 가 키워드로 존재한다. 굿
        override fun move() {
            println("나는 코틀린 나옹이다옹")
        }
    }

    class KotlinPenguin(
        species: String
    ) : KotlinAnimal(species, 2), Swimable, Flyable {

        private val wingCount: Int = 2

        // interface 에 정의된 프로퍼티(정확히는 getter...) 는 이런 식으로 override
        override val swimAbility: Int
            get() = 3

        override val legCount: Int
            get() = super.legCount + this.wingCount

        override fun move() {
            println("나는 펭귄")
        }

        override fun act() {
            // 중복되는 시그니처를 가진 인터페이스를 구현해야 한다면 이렇게 <> 안에 특정 타입을 지정한다.
            super<Swimable>.act()
            super<Flyable>.act()
        }
    }

    interface Flyable {

        // default 키워드 없이도 그냥 쓰면 됨 굿
        fun act() {
            println("파닥 파닥")
        }

        // 구현 해야 하는 시그니처는 이렇게 표현하는듯
//        fun act2()
    }

    interface Swimable {

        // 인터페이스에서 값도 정의할 수 있는듯
        // 정확히는 getter setter 이겠지만...
        val swimAbility: Int

        // 이렇게 기본 값을 지정 하는 것도 가능하다
//        val swimAbility: Int
//            get() = 3

        fun act() {
            println("어푸 어푸")
        }
    }

    open class Base(
        open val number: Int = 100
    ) {
        init {
            println("Base class")
            println(number)
        }
    }

    class Derived(
        override val number: Int
    ) : Base(number) {

        init {
            println("Derived Class")
        }
    }
}