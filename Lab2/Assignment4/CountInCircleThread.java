package Assignment4;

public class CountInCircleThread extends Thread {
    private Data data;

    public CountInCircleThread(Data data) {
        this.data = data;
    }

    public void run() {
        for (Vertex vertex : data.list) {
            double xSquare = vertex.x * vertex.x;
            double ySquare = vertex.y * vertex.y;
            double distance = xSquare + ySquare;
            if (distance <= data.radius) {
                data.countInCircle++;
            }
        }
        System.out.println("data.countInCircle: " + data.countInCircle);
    }
}
