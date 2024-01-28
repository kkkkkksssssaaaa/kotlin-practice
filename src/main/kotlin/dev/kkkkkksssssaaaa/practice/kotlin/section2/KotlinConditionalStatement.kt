package dev.kkkkkksssssaaaa.practice.kotlin.section2

class KotlinConditionalStatement {

    fun validateScoreIsNotNegative(score: Int): Unit {
        if (score < 0) {
            throw IllegalStateException("${score}는 0보다 작을 수 없습니다.")
        }
    }

    fun getPassOrFail(score: Int): String {
//        if (score >= 50) {
//            return "P"
//        } else {
//            return "F"
//        }
        // 코틀린의 if 문은 Expression 이기 때문에 하나의 값으로 반환할 수 있다.
        // 그래서 굳이 삼항연산자가 필요 없당!
        return if (score >= 50) {
            "P"
        } else {
            "F"
        }
    }

    fun getGrade(score: Int): String {
        return if (score >= 90) {
            "A"
        } else if (score >= 80) {
            "B"
        } else if (score >= 70) {
            "C"
        } else {
            "D"
        }
    }

    fun rangeCheck(score: Int) {
        // 0 <= score <= 100 과 동일함
        if (score in 0..100) {
            println("ok")
        }

        // score 가 0부터 100 범위에 들지 않는 경우..
        if (score !in 0..100) {

        }
    }

    // switch-case 는 사라지고 when 으로 간략하게 사용할 수 있음
    fun getGradeWithSwitch(score: Int): String {
        return when (score / 10) {
            9 -> "A"
            8 -> "B"
            7 -> "C"
            else -> "D"
        }
    }

    fun getGradeWithSwitch2(score: Int): String {
        return when (score) {
            // when 문에서는 이런 조건을 넣어 분기 처리 하는 것도 가능하다
            in 90..99 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else -> "D"
        }
    }

    fun startsWithA(obj: Any): Boolean {
        return when (obj) {
            is String -> {
                // 이 경우, obj 의 instance 가 String 인 것이 이미 검증 되었기 때문에
                // String 의 함수를 바로 호출 할 수 있음
                obj.startsWith("A")
            }
            else -> false
        }
    }

    fun judgeNumber(number: Int) {
        when (number) {
            // java: if (number == 1 || number == 0 || number == -1)
            1, 0, -1 -> println("어디서 많이 본 숫자입니다")
            else -> println("1, 0, -1 이 아닙니다")
        }
    }

    fun judgeNumber2(number: Int) {
        // when 문은 값 없이도 수행 가능하다
        when {
            number == 0 -> println("주어진 숫자는 0입니다")
            number % 2 == 0 -> println("주어진 숫자는 짝수입니다")
            else -> println("주어진 숫자는 홀수입니다")
        }
    }
}