package Assignment3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReadersWriters {
    private int readers = 0;
    private int writers = 0;
    private int waitingWriters = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition readCondition = lock.newCondition();
    private final Condition writeCondition = lock.newCondition();

    public void startRead() throws InterruptedException {
        lock.lock();
        try {
            while (writers > 0 || waitingWriters > 0) {
                readCondition.await();
            }
            readers++;
        } finally {
            lock.unlock();
        }
    }

    public void endRead() {
        lock.lock();
        try {
            readers--;
            if (readers == 0) {
                writeCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void startWrite() throws InterruptedException {
        lock.lock();
        try {
            waitingWriters++;
            while (readers > 0 || writers > 0) {
                writeCondition.await();
            }
            waitingWriters--;
            writers++;
        } finally {
            lock.unlock();
        }
    }

    public void endWrite() {
        lock.lock();
        try {
            writers--;
            if (waitingWriters > 0) {
                writeCondition.signal();
            } else {
                readCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
