package test;

import java.util.Arrays;

public class RunnableTest {

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Runnable: Active Count: "+ Thread.activeCount());
            System.out.println("Runnable: Current Thread: "+ Thread.currentThread());
            Thread.getAllStackTraces().forEach((t,st)->{
                System.out.println("-------------------------------------------");
                System.out.println(t.getName());
                System.out.println(Arrays.stream(st).map(el -> el.getClassName()).reduce("", String::concat));
            });
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread t1 = new Thread(runnable,"T1");

        t1.start();

    }
}
