package Assignment4;

public class Barrier {
    private final int totalParties;
    private int waitingParties;
    private final Object lock = new Object();

    public Barrier(int parties) {
        if (parties <= 0) {
            throw new IllegalArgumentException("Number of parties must be greater than zero.");
        }
        this.totalParties = parties;
        this.waitingParties = 0;
    }

    public void await() {
        synchronized (lock) {
            waitingParties++;
            if (waitingParties == totalParties) {
                lock.notifyAll();
            } else {
                while (waitingParties < totalParties) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Thread interrupted while waiting at barrier", e);
                    }
                }
            }
        }
    }
}
