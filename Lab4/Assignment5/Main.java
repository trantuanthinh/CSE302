package Assignment5;

public class Main {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        int numberOfCars = 10;

        Thread[] cars = new Thread[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            int carId = i + 1;
            int direction = i % 2;
            cars[i] = new Thread(() -> {
                System.out.println("Car " + carId + " arriving at bridge wanting to go in direction " + direction);
                bridge.arriveBridge(direction);
                System.out.println("Car " + carId + " on the bridge going in direction " + direction);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                bridge.exitBridge();
                System.out.println("Car " + carId + " exited the bridge from direction " + direction);
            });
            cars[i].start();
        }

        for (int i = 0; i < numberOfCars; i++) {
            try {
                cars[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Main thread interrupted while waiting for other threads to finish.");
            }
        }

        System.out.println("All cars have crossed the bridge.");
    }
}
