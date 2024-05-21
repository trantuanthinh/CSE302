package Assignment2;

public class thread_2 extends Thread {
    private final TSQueue queue;

    public thread_2(TSQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int value = queue.removeFirst();
                System.out.println("thread_2: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
