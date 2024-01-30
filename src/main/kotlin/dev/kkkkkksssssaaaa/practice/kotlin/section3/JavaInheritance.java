package dev.kkkkkksssssaaaa.practice.kotlin.section3;

public class JavaInheritance {

    abstract class JavaAnimal {

        protected final String species;
        protected final int legCount;

        public JavaAnimal(String species, int legCount) {
            this.species = species;
            this.legCount = legCount;
        }

        public String getSpecies() {
            return species;
        }

        public int getLegCount() {
            return legCount;
        }

        public abstract void move();
    }

    class JavaCat extends JavaAnimal {

        public JavaCat(String species, int legCount) {
            super(species, legCount);
        }

        @Override
        public void move() {
            System.out.println("나는 자바 나옹이다옹");
        }
    }

    class JavaPenguin extends JavaAnimal implements Flyable, Swimable {

        private final int wingCount;

        public JavaPenguin(String species, int legCount, int wingCount) {
            super(species, legCount);
            this.wingCount = wingCount;
        }

        @Override
        public int getLegCount() {
            return super.legCount + this.wingCount;
        }

        @Override
        public void move() {
            System.out.println("나는 펭귄");
        }

        @Override
        public void act() {
            Swimable.super.act();
            Flyable.super.act();
        }
    }

    interface Flyable {

        default void act() {
            System.out.println("파닥 파닥");
        }
    }

    interface Swimable {

        default void act() {
            System.out.println("어푸 어푸");
        }
    }
}
