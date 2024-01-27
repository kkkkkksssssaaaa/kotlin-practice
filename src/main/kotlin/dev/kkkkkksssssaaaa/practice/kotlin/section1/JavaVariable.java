package dev.kkkkkksssssaaaa.practice.kotlin.section1;

import java.util.ArrayList;
import java.util.List;

public class JavaVariable {

    void doSomething() {
        long number1 = 10L;
        final long number2 = 10L;

        Long number3 = 1_000L;
        Person person = new Person("왕해삼");

        List<Integer> numbers = new ArrayList<>();
    }

    static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }
    }
}
