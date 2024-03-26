package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section2;

public class JavaConditionalStatement {

    void validateScoreIsNotNegative(int score) {
        if (score < 0) {
            throw new IllegalStateException(String.format("%s 는 0보다 작을 수 없습니다.", score));
        }
    }

    String getPassOrFail(int score) {
        if (score >= 50) {
            return "P";
        } else {
            return "F";
        }
    }

    String getGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else {
            return "D";
        }
    }
}
