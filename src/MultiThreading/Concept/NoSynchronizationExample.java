package MultiThreading.Concept;

public class NoSynchronizationExample {

    private static int sharedCounter = 0;

    public static void main(String[] args) {
        // Creating two threads
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());

        // Starting the threads
        thread1.start();
        thread2.start();

        // Waiting for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Expected result: 2000 (2 threads incrementing 1000 times each)
        System.out.println("Final counter value: " + sharedCounter);
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                // Without synchronization, this operation is not atomic
                sharedCounter++;
            }
        }
    }
}