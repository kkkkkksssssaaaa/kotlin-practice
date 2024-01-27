package dev.kkkkkksssssaaaa.practice.kotlin.section1;

import dev.kkkkkksssssaaaa.practice.kotlin.common.Person;

public class JavaType {

    void doSomething() {
        int number1 = 4;

        // 자바에선 타입 변환이 암시적으로 가능하다.
        long number2 = number1;

        System.out.println(number1 + number2);
    }

    void printAgeIfPerson(Object o) {
        if (o instanceof Person) {
            Person person = (Person) o;
            System.out.println(person.getAge());
        }
    }
}
