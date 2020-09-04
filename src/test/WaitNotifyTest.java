package test;

public class WaitNotifyTest {

    public static void main(String[] args) {
        String resource = "resource";
        Thread t1 = new Thread(() -> {
            synchronized (resource) {
                System.out.println("Inside " + Thread.currentThread().getName() + " sync block");
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting");
                    resource.wait();
                    System.out.println(Thread.currentThread().getName() + " released");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T1");
        Thread t3 = new Thread(() -> {
            synchronized (resource) {
                System.out.println("Inside " + Thread.currentThread().getName() + " sync block");
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting");
                    resource.wait();
                    System.out.println(Thread.currentThread().getName() + " released");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resource) {
                System.out.println("Inside " + Thread.currentThread().getName() + " sync block");
                resource.notify();
                System.out.println(Thread.currentThread().getName() + " notified ");
            }
        }, "T2");
        Thread t4 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resource) {
                System.out.println("Inside " + Thread.currentThread().getName() + " sync block");
                resource.notify();
                System.out.println(Thread.currentThread().getName() + " notified ");
            }
        }, "T4");

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start();
    }
}
