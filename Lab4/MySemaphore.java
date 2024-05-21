import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MySemaphore {
    private int permit;
    private ReentrantLock lock = new ReentrantLock();
    private LinkedList<Condition> condList = new LinkedList<>();

    public MySemaphore(int permit) {
        this.permit = permit;
    }

    // down
    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            if (this.permit > 0)
                this.permit--;
            else {
                Condition c = this.lock.newCondition();
                this.condList.addLast(c);
                c.await();
            }
        } finally {
            lock.unlock();
        }
    }

    // up
    public void release() {
        lock.lock();
        try {
            if (this.condList.isEmpty() == false) {
                Condition c = this.condList.remove(0); // remove(0)
                c.signal();
            } else
                this.permit++;
        } finally {
            lock.unlock();
        }
    }
}