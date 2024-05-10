package Assignment1;

import java.util.concurrent.Semaphore;

public class SharedDataSemaphore {
    private int sharedVariable = 0;
    private final Semaphore semaphore = new Semaphore(1);

    public void incrementWithSemaphore() throws InterruptedException {
        semaphore.acquire();
        try {
            sharedVariable++;
        } finally {
            semaphore.release();
        }
    }

    public void decrementWithSemaphore() throws InterruptedException {
        semaphore.acquire();
        try {
            sharedVariable--;
        } finally {
            semaphore.release();
        }
    }

    public int getSharedVariable() {
        return sharedVariable;
    }
}
