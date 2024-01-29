package dev.kkkkkksssssaaaa.practice.kotlin.section2;

import java.util.Arrays;
import java.util.List;

public class JavaLoopStatement {

    void doSomething() {
        List<Long> numbers = Arrays.asList(1L, 2L, 3L);

        for (long n : numbers) {
            System.out.println(n);
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }

        for (int i = 3; i >= 1; i--) {
            System.out.println(i);
        }

        for (int i = 1; i <= 5; i += 2) {
            System.out.println(i);
        }
    }
}
