package Assignment5;

public class Bridge {
    private int carsOnBridge = 0;
    private int currentDirection = -1;
    private final int MAX_CARS = 3;
    private final Object lock = new Object();

    public Bridge() {
    }

    public void arriveBridge(int direction) {
        synchronized (lock) {
            while (carsOnBridge == MAX_CARS || (carsOnBridge > 0 && currentDirection != direction)) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted while waiting to arrive at bridge", e);
                }
            }
            carsOnBridge++;
            currentDirection = direction;
        }
    }

    public void exitBridge() {
        synchronized (lock) {
            carsOnBridge--;
            if (carsOnBridge == 0) {
                currentDirection = -1;
            }
            lock.notifyAll();
        }
    }
}
