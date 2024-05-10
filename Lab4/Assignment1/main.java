package Assignment1;

public class main {
    public static void main(String[] args) throws InterruptedException {
        ShareDataSync sharedDataSync = new ShareDataSync();
        SharedDataLock sharedDataLock = new SharedDataLock();
        SharedDataSemaphore sharedDataSemaphore = new SharedDataSemaphore();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sharedDataSync.incrementSynchronized();
                sharedDataLock.incrementWithLock();
                try {
                    sharedDataSemaphore.incrementWithSemaphore();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sharedDataSync.decrementSynchronized();
                sharedDataLock.decrementWithLock();
                try {
                    sharedDataSemaphore.decrementWithSemaphore();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Shared variable value - Sync: " + sharedDataSync.getSharedVariable());
        System.out.println("Shared variable value - Lock: " + sharedDataLock.getSharedVariable());
        System.out.println("Shared variable value - Semaphore: " + sharedDataSemaphore.getSharedVariable());
    }
}
