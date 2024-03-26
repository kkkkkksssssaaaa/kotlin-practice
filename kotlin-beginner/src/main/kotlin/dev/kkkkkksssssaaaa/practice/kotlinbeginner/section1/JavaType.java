package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section1;

import dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person;
import dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person;

public class JavaType {

    void doSomething() {
        int number1 = 4;

        // 자바에선 타입 변환이 암시적으로 가능하다.
        long number2 = number1;

        System.out.println(number1 + number2);
    }

    void printAgeIfPerson(Object o) {
        if (o instanceof dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person) {
            dev.kkkkkksssssaaaa.practice.kotlinbeginner.common.Person person = (Person) o;
            System.out.println(person.getAge());
        }
    }
}
