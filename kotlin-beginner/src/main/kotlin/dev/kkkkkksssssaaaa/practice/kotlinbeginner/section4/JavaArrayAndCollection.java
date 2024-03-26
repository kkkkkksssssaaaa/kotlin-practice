package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section4;

import java.util.List;

public class JavaArrayAndCollection {

    void doSomething() {
        int[] array = {100, 200};

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s %s", i, array[i]);
        }
    }

    final List<Integer> numbers = List.of(100, 200);
}
