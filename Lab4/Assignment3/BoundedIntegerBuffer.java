package Assignment3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedIntegerBuffer {
    private final int[] buffer;
    private int capacity;
    private int size;
    private int head;
    private int tail;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public BoundedIntegerBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    public void add(int value) throws InterruptedException {
        this.lock.lock();
        try {
            while (size == capacity) {
                notFull.await();
            }
            buffer[tail] = value;
            tail = (tail + 1) % capacity;
            size++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int remove() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            int value = buffer[head];
            head = (head + 1) % capacity;
            size--;
            notFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}