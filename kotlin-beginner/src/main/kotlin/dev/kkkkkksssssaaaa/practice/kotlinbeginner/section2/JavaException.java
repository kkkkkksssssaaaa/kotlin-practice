package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section2;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaException {

    int doSomething(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(String.format("주어진 숫자 %s는 숫자가 아닙니다.", str));
        }
    }

    Integer doSomething2(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    void doSomething3() throws IOException {
        File currentFile = new File(".");
        File file = new File(currentFile.getAbsoluteFile() + "/a.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());

        reader.close();
    }

    void doSomething4(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }
}
