package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section2;

public class JavaFunction {
    
    int max(int a, int b) {
        if (a > b) {
            return a;
        }

        return b;
    }

    public static void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }

    // 자바는 오버로딩 가능ㅎ
    void repeat(String str, int num) {
        repeat(str, num, true);
    }

    // 인자 개수나 타입만 다르면 얼마든지 오버로딩이 가능
    void repeat(String str) {
        repeat(str, 3, true);
    }
}
