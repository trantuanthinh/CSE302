package Assignment4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Data data = new Data();

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        GenerateRandomThread generateRandomThread = new GenerateRandomThread(data, number);
        CountInCircleThread countInCircleThread = new CountInCircleThread(data);
        CountInSquareThread countInSquareThread = new CountInSquareThread(data);
        CalculatePiThread calculatePiThread = new CalculatePiThread(data);
        OutputThread outputThread = new OutputThread(data);

        generateRandomThread.start();
        try {
            generateRandomThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countInCircleThread.start();
        countInSquareThread.start();
        try {
            countInCircleThread.join();
            countInSquareThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        calculatePiThread.start();
        try {
            calculatePiThread.join();
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
