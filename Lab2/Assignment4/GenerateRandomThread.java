package Assignment4;

import java.util.Random;

public class GenerateRandomThread extends Thread {
    private int number;
    private Data data;
    double start = -1.0f;
    double end = 1.0f;

    public GenerateRandomThread(Data data, int number) {
        this.number = number;
        this.data = data;
    }

    public void run() {
        Random random = new Random();
        for (int i = 0; i < this.number; i++) {
            double x = start + (end - start) * random.nextDouble();
            double y = start + (end - start) * random.nextDouble();
            System.out.println(x + " " + y);
            Vertex vertex = new Vertex(x, y);
            data.list.add(vertex);
        }
    }
}
