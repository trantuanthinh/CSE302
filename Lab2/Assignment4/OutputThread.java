package Assignment4;

public class OutputThread extends Thread {
    private Data data;

    public OutputThread(Data data) {
        this.data = data;
    }

    public void run() {
        System.out.println("data.pi: " + data.pi);
    }
}
