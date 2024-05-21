package Assignment2;

public class thread_1 extends Thread {
    private final TSQueue queue;

    public thread_1(TSQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.addLast(i);
            System.out.println("thread_1: " + i);
        }
    }
}
