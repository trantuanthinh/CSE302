package Assignment3;

public class thread_1 extends Thread {
    private final BoundedIntegerBuffer buffer;

    public thread_1(BoundedIntegerBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.add(i);
                System.out.println("add: " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
