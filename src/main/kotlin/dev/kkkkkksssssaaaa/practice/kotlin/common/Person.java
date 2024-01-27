package dev.kkkkkksssssaaaa.practice.kotlin.common;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Person {

    private int age = 0;
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Nullable
    public String getNullableName() {
        return this.name;
    }

    @NotNull
    public String getNotNullName() {
        return this.name;
    }
}
