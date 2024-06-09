package Assignment4;

public class Main {
    public static void main(String[] args) {
        ReadersWriters database = new ReadersWriters();

        Runnable readerTask = () -> {
            try {
                database.startRead();
                System.out.println(Thread.currentThread().getName() + " is reading.");
                Thread.sleep(1000); // Simulate reading time
                System.out.println(Thread.currentThread().getName() + " has finished reading.");
                database.endRead();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable writerTask = () -> {
            try {
                database.startWrite();
                System.out.println(Thread.currentThread().getName() + " is writing.");
                Thread.sleep(1000); // Simulate writing time
                System.out.println(Thread.currentThread().getName() + " has finished writing.");
                database.endWrite();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Create and start reader and writer threads for demonstration
        Thread r1 = new Thread(readerTask, "Reader 1");
        Thread r2 = new Thread(readerTask, "Reader 2");
        Thread w1 = new Thread(writerTask, "Writer 1");
        Thread w2 = new Thread(writerTask, "Writer 2");

        r1.start();
        r2.start();
        w1.start();
        w2.start();
    }
}
