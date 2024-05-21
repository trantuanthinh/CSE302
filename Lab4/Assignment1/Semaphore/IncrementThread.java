package Assignment1.Semaphore;

public class IncrementThread extends Thread {
    private SharedData sharedData;

    public IncrementThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            try {
                sharedData.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
