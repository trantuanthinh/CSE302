package Assignment2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TSQueue {
    private final Queue<Integer> queue;
    private final Lock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    private final int capacity;

    public TSQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
        this.capacity = capacity;
    }

    public void addLast(int value) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.add(value);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int removeFirst() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            int value = queue.remove();
            notFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}
