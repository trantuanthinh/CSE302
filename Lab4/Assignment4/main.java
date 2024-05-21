package Assignment4;

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        Barrier barrier = new Barrier(numberOfThreads);

        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " reached the barrier.");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " crossed the barrier.");
            }, "Thread-" + (i + 1));
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Main thread interrupted while waiting for other threads to finish.");
            }
        }

        System.out.println("All threads have crossed the barrier.");
    }
}
