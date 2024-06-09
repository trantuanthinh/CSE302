package Assignment1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class WaterMonitor {
    private int hydrogenCount = 0;
    private int oxygenCount = 0;
    private int water = 0;
    private Lock lock = new ReentrantLock();
    private Condition hydrogenCondition = this.lock.newCondition();
    private Condition oxygenCondition = this.lock.newCondition();

    public WaterMonitor() {
    }

    public void hydrogen() throws InterruptedException {
        this.lock.lock();
        if (hydrogenCount == 1 || oxygenCount > 0) {
            this.hydrogenCount--;
            this.oxygenCount--;
            this.hydrogenCondition.signal();
            this.oxygenCondition.signal();
        } else {
            this.hydrogenCount++;
            this.hydrogenCondition.await();
        }
        water++;
        this.lock.unlock();
    }

    public void oxygen() throws InterruptedException {
        this.lock.lock();
        if (oxygenCount == 0 || hydrogenCount > 1) {
            this.hydrogenCount--;
            this.oxygenCount--;
            this.hydrogenCondition.signal();
            this.oxygenCondition.signal();
        } else {
            this.oxygenCount++;
            this.oxygenCondition.await();
        }
        water++;
        this.lock.unlock();
    }

    public int getWater() {
        return this.water;
    }
}
