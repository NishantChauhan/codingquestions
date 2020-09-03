package test;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicOperations {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.getAndIncrement();
        System.out.println(atomicLong);
    }
}
