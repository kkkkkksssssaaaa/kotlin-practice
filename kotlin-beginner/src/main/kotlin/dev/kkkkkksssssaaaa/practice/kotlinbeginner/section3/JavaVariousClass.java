package dev.kkkkkksssssaaaa.practice.kotlinbeginner.section3;

public class JavaVariousClass {

    class JavaDataClass {

        private final String name;
        private final int age;

        public JavaDataClass(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaDataClass that = (JavaDataClass) o;

            if (age != that.age) return false;
            return name.equals(that.name);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + age;
            return result;
        }

        @Override
        public String toString() {
            return "JavaDataClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
        }
    }

    enum JavaEnum {

        KOREA("KO"),
        AMERICA("US");

        private final String code;

        JavaEnum(String code) {
            this.code = code;
        }

        public static void handle(JavaEnum javaEnum) {
            if (javaEnum == KOREA) {
                // do something
            }

            if (javaEnum == AMERICA) {
                // do something
            }
        }

        public String getCode() {
            return code;
        }
    }
}
