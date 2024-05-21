package Assignment3;

public class thread_2 extends Thread {
    private final BoundedIntegerBuffer buffer;

    public thread_2(BoundedIntegerBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int value = buffer.remove();
                System.out.println("remove: " + value);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
