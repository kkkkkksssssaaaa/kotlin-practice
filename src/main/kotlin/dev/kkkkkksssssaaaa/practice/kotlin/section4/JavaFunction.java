package dev.kkkkkksssssaaaa.practice.kotlin.section4;

public class JavaFunction {

    public static class Person {

        private final String firstName;
        private final String lastName;
        public final int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int nextYearAge() {
            System.out.println("멤버 함수");

            return this.age + 1;
        }
    }
}
