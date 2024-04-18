package Assignment1;

public class DecreasedThread extends Thread {
    private SharedData sharedData;

    public DecreasedThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            sharedData.variable--;
        }
    }
}
