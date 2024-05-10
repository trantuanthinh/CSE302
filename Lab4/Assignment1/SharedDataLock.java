package Assignment1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedDataLock {
    private int sharedVariable = 0;
    private final Lock reentrantLock = new ReentrantLock();

    // Using ReentrantLock class
    public void incrementWithLock() {
        reentrantLock.lock();
        try {
            sharedVariable++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void decrementWithLock() {
        reentrantLock.lock();
        try {
            sharedVariable--;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int getSharedVariable() {
        return sharedVariable;
    }
}
