package test;

import javafx.collections.ObservableSet;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    static class TestThread extends Thread{
        String threadName;
        TestThread(String threadName){
            this.threadName=threadName;
        }

        @Override
        public void run() {
            System.out.println(threadName + " is running");
        }
    }

    public static void main(String[] args) {

        System.out.println(TimeUnit.SECONDS.toMillis(2));

        TestThread t1 = new TestThread("T1");
        TestThread t2 = new TestThread("T2");
        TestThread t3 = new TestThread("T3");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();



    }
}
