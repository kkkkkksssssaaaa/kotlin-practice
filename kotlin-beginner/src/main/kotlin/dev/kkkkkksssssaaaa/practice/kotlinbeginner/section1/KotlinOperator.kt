package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section1

import dev.kkkkkksssssaaaa.practice.kotlinbeginner.section1.JavaOperator.JavaMoney

class KotlinOperator {

    fun doSomething() {
        val money1: JavaMoney = JavaMoney(2_000L)
        val money2: JavaMoney = JavaMoney(1_000L)

        // CompareTo 를 자동으로 호출해준다
        if (money1 > money2) {
            println("Money1 이 Money2 보다 금액이 큽니다")
        }
    }

    fun doSomething2() {
        val money1: JavaMoney = JavaMoney(1_000L)
        val money2: JavaMoney = JavaMoney(1_000L)
        val money3: JavaMoney = money1;

        if (money1 == money2) {
            println("money1 과 money2 는 동등하다")
        }

        if (money1 === money3) {
            println("money1 과 money2 는 동일하다")
        }
    }

    fun lazyOperation() {
        if (fun1() || fun2()) {
            println("자바와 마찬가지로 조건문이 이미 만족하는 경우, 뒤에 오는 조건문은 수행하지 않음")
        }
    }

    fun fun1(): Boolean {
        println("fun1")
        return true
    }

    fun fun2(): Boolean {
        println("fun2")
        return false
    }

    fun useOperatorOverriding() {
        val money1 = Money(1_000L)
        val money2 = Money(2_000L)

        println(money1 + money2)
    }

    data class Money(
        val amount: Long
    ) {

        // 코틀린은 연산자 오버로딩이 가능하다.
        operator fun plus(other: Money): Money {
            return Money(this.amount + other.amount)
        }
    }
}
