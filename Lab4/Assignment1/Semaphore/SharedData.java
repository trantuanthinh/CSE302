package Assignment1.Semaphore;

import java.util.concurrent.Semaphore;

public class SharedData {
    private int sharedVariable = 0;
    private Semaphore semaphore = new Semaphore(1);

    public void increment() throws InterruptedException {
        semaphore.acquire();
        sharedVariable++;
        semaphore.release();
    }

    public void decrement() throws InterruptedException {
        semaphore.acquire();
        sharedVariable--;
        semaphore.release();
    }

    public int getSharedVariable() {
        return sharedVariable;
    }
}
