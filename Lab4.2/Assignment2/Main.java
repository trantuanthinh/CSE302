package Assignment2;

public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            threadPool.add(() -> {
                System.out.println("Executing task " + taskNumber);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        threadPool.shutdown();
    }
}
