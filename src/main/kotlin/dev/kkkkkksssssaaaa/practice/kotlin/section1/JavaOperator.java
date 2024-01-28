package dev.kkkkkksssssaaaa.practice.kotlin.section1;

import org.jetbrains.annotations.NotNull;

public class JavaOperator {

    void doSomething() {
        JavaMoney money1 = new JavaMoney(2_000L);
        JavaMoney money2 = new JavaMoney(1_000L);

        if (money1.compareTo(money2) > 0) {
            System.out.println("Money1 이 Money2 보다 금액이 큽니다");
        }

        // 자바에선 특정 객체에 대한 연산을 수행하려면, 수행하려는 로직을 담은 메서드를 만들어야 한다.
        money1.plus(money2);
    }

    public static class JavaMoney implements Comparable<JavaMoney> {

        private final long amount;

        public JavaMoney(long amount) {
            this.amount = amount;
        }

        public JavaMoney plus(JavaMoney other) {
            return new JavaMoney(this.amount + other.amount);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaMoney javaMoney = (JavaMoney) o;

            return amount == javaMoney.amount;
        }

        @Override
        public int hashCode() {
            return (int) (amount ^ (amount >>> 32));
        }

        @Override
        public int compareTo(@NotNull JavaMoney o) {
            return Long.compare(this.amount, o.amount);
        }
    }
}
