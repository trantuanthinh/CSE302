package Assignment4;

public class CalculatePiThread extends Thread {
    private Data data;

    public CalculatePiThread(Data data) {
        this.data = data;
    }

    public void run() {
        data.pi = 4.0 * data.countInCircle / data.countInSquare;
    }
}
