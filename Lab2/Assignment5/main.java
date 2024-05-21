package Assignment5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        GenerateFiboThread generateFiboThread = new GenerateFiboThread(data, number);
        OutputThread outputThread = new OutputThread(data);

        generateFiboThread.start();
        try {
            generateFiboThread.join();
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
