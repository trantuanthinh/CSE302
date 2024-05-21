package Assignment2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TSQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();

    public void addLast(int value) {
        lock.lock();
        try {
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
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }

    public Queue<Integer> getQueue() {
        return this.queue;
    }
}
