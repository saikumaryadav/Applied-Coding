package MultiThreading.Concept;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Note: creation of dead lock and resolving by interchanging the locks for thread2
public class TestingLocks {
    public static void main(String[] args) {

        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                synchronized (l1) {
                    System.out.println("Deadlock created");
                    synchronized (l2) {

                    }
                }
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                synchronized (l2) {
                    synchronized (l1) {
                        System.out.println("hello");
                    }
                }
            }
        };

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();

        System.out.println("end----");
    }
}
