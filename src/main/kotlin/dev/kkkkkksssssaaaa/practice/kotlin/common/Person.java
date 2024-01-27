package dev.kkkkkksssssaaaa.practice.kotlin.common;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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
