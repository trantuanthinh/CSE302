package Assignment4;

public class CountInSquareThread extends Thread {
    private Data data;

    public CountInSquareThread(Data data) {
        this.data = data;
    }

    public void run() {
        data.countInSquare = data.list.size();
        System.out.println("data.countInSquare: " + data.countInSquare);

    }
}
