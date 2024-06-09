package Lab5.Assignment2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private final Lock lock = new ReentrantLock();
    private int availableChopsticks;

    public DiningPhilosophers(int totalChopsticks) {
        this.availableChopsticks = totalChopsticks;
    }

    public boolean requestChopstick(int philosopherId) {
        lock.lock();
        try {
            if (availableChopsticks >= 2) {
                availableChopsticks--;
                System.out.println(
                        "Philosopher " + philosopherId + " picked up a chopstick. Available: " + availableChopsticks);
                return true;
            } else {
                System.out.println("Philosopher " + philosopherId + " must wait. Available: " + availableChopsticks);
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void releaseChopstick(int philosopherId) {
        lock.lock();
        try {
            availableChopsticks++;
            System.out.println(
                    "Philosopher " + philosopherId + " released a chopstick. Available: " + availableChopsticks);
        } finally {
            lock.unlock();
        }
    }
}
