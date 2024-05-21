package Assignment1.ReentrantLock;

public class DecrementThread extends Thread {
    private SharedData sharedData;

    public DecrementThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            sharedData.decrement();
        }
    }
}
