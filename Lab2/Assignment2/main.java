package Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Data data = new Data();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        MinNumberThread min = new MinNumberThread(list, data);
        MaxNumberThread max = new MaxNumberThread(list, data);
        AverageNumberThread average = new AverageNumberThread(list, data);
        min.start();
        max.start();
        average.start();

        try {
            min.join();
            max.join();
            average.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final min value of the variable: " + data.min);
        System.out.println("Final average value of the variable: " + data.average);
        System.out.println("Final max value of the variable: " + data.max);
    }
}
