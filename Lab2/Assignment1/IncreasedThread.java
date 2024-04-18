package Assignment1;

public class IncreasedThread extends Thread {
    private SharedData sharedData;

    public IncreasedThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        for (int i = 0; i < 1000000; i++) {
            sharedData.variable++;
        }
    }
}
