package Assignment3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Data data = new Data();

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        PrimeNumberThread primeNumberThread = new PrimeNumberThread(data, number);
        OutputThread outputThread = new OutputThread(data);

        primeNumberThread.start();

        try {
            primeNumberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        outputThread.start();
        try {
            outputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}