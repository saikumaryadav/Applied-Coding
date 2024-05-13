package MultiThreading.Concept;

public class PrintSequenceNumbers implements Runnable{

    static Object lock = new Object();
    static  int number =1;
    int remainder;
    PrintSequenceNumbers(int remainder){
        this.remainder = remainder;
    }

    public static void main(String[] args) {

        PrintSequenceNumbers r1 = new PrintSequenceNumbers(1);
        PrintSequenceNumbers r2 = new PrintSequenceNumbers(2);
        PrintSequenceNumbers r3 = new PrintSequenceNumbers(0);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();

    }
    @Override
    public void run() {

        synchronized (lock) {
            while (number <99) {
                while (number % 3 != remainder) {

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(number + " ");
                System.out.println(Thread.currentThread().getName());
                number++;
                lock.notifyAll();
            }
        }
    }
}
