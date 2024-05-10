package Assignment2;

public class main {
    public static void main(String[] args) {
        TSQueue tsQueue = new TSQueue(5);

        Runnable addTask = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    tsQueue.addLast(i);
                    System.out.println("Added: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable removeTask = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int value = tsQueue.removeFirst();
                    System.out.println("Removed: " + value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread addThread = new Thread(addTask);
        Thread removeThread = new Thread(removeTask);

        addThread.start();
        removeThread.start();

        try {
            addThread.join();
            removeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
