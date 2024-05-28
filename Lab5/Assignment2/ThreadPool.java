package Assignment2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {
    private final int size;
    private final WorkerThread[] workers;
    private final Queue<Runnable> taskQueue = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private volatile boolean isShutdown = false;

    public ThreadPool() {
        this.size = 10;
        this.workers = new WorkerThread[size];

        for (int i = 0; i < size; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }

    public ThreadPool(int size) {
        this.size = size;
        this.workers = new WorkerThread[size];

        for (int i = 0; i < size; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }

    public void add(Runnable task) {
        lock.lock();
        try {
            if (isShutdown) {
                throw new IllegalStateException("ThreadPool is shutdown");
            }
            taskQueue.add(task);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void shutdown() {
        lock.lock();
        try {
            isShutdown = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }

        for (WorkerThread worker : workers) {
            worker.interrupt();
        }
    }

    private class WorkerThread extends Thread {
        public void run() {
            Runnable task;
            while (true) {
                lock.lock();
                try {
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            if (isShutdown) {
                                return;
                            }
                        }
                    }
                    if (isShutdown && taskQueue.isEmpty()) {
                        return;
                    }
                    task = taskQueue.poll();
                } finally {
                    lock.unlock();
                }
                try {
                    task.run();
                } catch (RuntimeException e) {
                    throw e;
                }
            }
        }
    }
}