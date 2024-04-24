package Assignment5;

public class GenerateFiboThread extends Thread {
    private int number;
    private Data data;
    double start = -1.0f;
    double end = 1.0f;

    public GenerateFiboThread(Data data, int number) {
        this.number = number;
        this.data = data;
    }

    public void run() {
        data.fiboList.add(1);
        if (number > 1) {
            data.fiboList.add(1);
        }
        for (int i = 2; i < number; i++) {
            int a = data.fiboList.get(i - 1);
            int b = data.fiboList.get(i - 2);
            data.fiboList.add(a + b);
        }
    }
}
