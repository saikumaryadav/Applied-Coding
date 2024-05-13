package MultiThreading.Concept;

import java.util.concurrent.locks.Lock;

public class TestRunnable {
    public static void main(String[] args) {
        TestRunnable obj1 = new TestRunnable();

        //note: if i call a method from those run methods. the method should be synchronized if it is not synchronized in run method.

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("running thread1");
                synchronized (obj1) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(" i is :: " + i);
                    }
                }
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("running thread2");
                synchronized (obj1) {
                    for (int j = 0; j < 10; j++) {
                        System.out.println("j is " + j);
                    }
                }
            }
        };

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
