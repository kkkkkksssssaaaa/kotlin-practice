package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section3;

public class JavaClass {

    public static class Javaperson {

        private final String name;
        private int age;

        public Javaperson(String name, int age) {
            if (age <= 10) {
                throw new IllegalStateException(String.format("나이는 %s일 수 없습니다.", age));
            }
            this.name = name;
            this.age = age;
        }

        public Javaperson(String name) {
            this(name, 1);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
