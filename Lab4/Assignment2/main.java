package Assignment2;

import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TSQueue queue = new TSQueue();
        thread_1 thread_1 = new thread_1(queue);
        thread_2 thread_2 = new thread_2(queue);
        thread_1.start();
        thread_2.start();
        Queue<Integer> temp = queue.getQueue();
        System.out.println("Result: " + temp.size());
    }
}
