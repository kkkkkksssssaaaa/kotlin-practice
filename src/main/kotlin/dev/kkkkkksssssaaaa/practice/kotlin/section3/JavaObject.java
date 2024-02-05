package dev.kkkkkksssssaaaa.practice.kotlin.section3;

public class JavaObject {

    static class Person {

        private static final int MIN_AGE = 1;

        private String name;
        private int age;

        private Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static Person newBaby(String name) {
            return new Person(name, MIN_AGE);
        }
    }

    static class Singleton {

        private static final Singleton INSTANCE = new Singleton();

        private Singleton() {
        }

        static Singleton getInstance() {
            return INSTANCE;
        }
    }

    static class AnonymousClass {

        void doSomething() {
            moveSomething(new Movable() {

                @Override
                public void move() {
                    System.out.println("움직인당");
                }

                @Override
                public void fly() {
                    System.out.println("난다요");
                }
            });
        }

        void moveSomething(Movable mobable) {
            mobable.move();
            mobable.fly();
        }
    }

    interface Movable {

        void move();
        void fly();
    }
}
