package Assignment1.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedData {
    private int sharedVariable = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            sharedVariable++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            sharedVariable--;
        } finally {
            lock.unlock();
        }
    }

    public int getSharedVariable() {
        return sharedVariable;
    }
}
