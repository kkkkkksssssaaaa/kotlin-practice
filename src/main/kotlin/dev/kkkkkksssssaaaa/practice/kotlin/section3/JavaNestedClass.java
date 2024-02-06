package dev.kkkkkksssssaaaa.practice.kotlin.section3;

public class JavaNestedClass {
}

class JavaHouse {

    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    void doSomething() {
        JavaHouse javaHouse = new JavaHouse("제주도");
        System.out.println(javaHouse.getLivingRoom().getAddress());
    }

    class LivingRoom {

        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }

        public String getAddress() {
            return JavaHouse.this.address;
        }
    }
}
