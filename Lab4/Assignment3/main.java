package Assignment3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BoundedIntegerBuffer boundedIntegerBuffer = new BoundedIntegerBuffer(10);
        thread_1 thread_1 = new thread_1(boundedIntegerBuffer);
        thread_2 thread_2 = new thread_2(boundedIntegerBuffer);

        thread_1.start();
        thread_2.start();
    }
}
