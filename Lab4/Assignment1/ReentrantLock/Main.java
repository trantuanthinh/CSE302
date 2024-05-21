package Assignment1.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedData sharedData = new SharedData();
        IncrementThread incrementThread = new IncrementThread(sharedData);
        DecrementThread decrementThread = new DecrementThread(sharedData);
        incrementThread.start();
        decrementThread.start();
        System.out.println("Final shared variable value: " + sharedData.getSharedVariable());
    }
}
