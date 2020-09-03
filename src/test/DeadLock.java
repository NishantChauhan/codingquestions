package test;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    static String resource1 = "Resource1";
    static String resource2 = "Resource2";

    private static class ResourceConsumer extends Thread {
        String name;
        boolean sequence;

        ResourceConsumer(String name, boolean sequence) {
            this.name = name;
            this.sequence = sequence;
        }

        @Override
        public void run() {
            if (sequence) {
                synchronized (resource1) {
                    System.out.println(resource1 + " is locked by " + this.name);
                    synchronized (resource2) {
                        System.out.println(resource2 + " is locked by " + this.name);
                    }
                }
            }
            else{
                synchronized (resource2) {
                    System.out.println(resource2 + " is locked by " + this.name);
                    synchronized (resource1) {
                        System.out.println(resource1 + " is locked by " + this.name);
                    }
                }

            }
        }
    }


    public static void main(String[] args) {
        ResourceConsumer r1 = new ResourceConsumer("T1",true);
        ResourceConsumer r2 = new ResourceConsumer("T2",false);

        r1.start();
        r2.start();
    }
}
