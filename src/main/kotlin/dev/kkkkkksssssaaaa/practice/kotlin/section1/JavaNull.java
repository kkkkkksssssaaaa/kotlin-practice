package dev.kkkkkksssssaaaa.practice.kotlin.section1;

public class JavaNull {

    boolean startsWithA(String str) {
        if (str == null) {
            throw new IllegalStateException("null");
        }

        return str.startsWith("A");
    }

    Boolean startsWithA2(String str) {
        if (str == null) {
            return null;
        }

        return str.startsWith("A");
    }

    boolean startsWithA3(String str) {
        if (str == null) {
            return false;
        }

        return str.startsWith("A");
    }
}
