package Assignment1.Semaphore;

public class DecrementThread extends Thread {
    private SharedData sharedData;

    public DecrementThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            try {
                sharedData.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
