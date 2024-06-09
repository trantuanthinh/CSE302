package Lab5.Assignment1;

public class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep((int) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep((int) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                synchronized (leftFork) {
                    System.out.println("Philosopher " + id + " picked up left fork " + leftFork.getId());
                    synchronized (rightFork) {
                        System.out.println("Philosopher " + id + " picked up right fork " + rightFork.getId());
                        eat();
                        System.out.println("Philosopher " + id + " put down right fork " + rightFork.getId());
                    }
                    System.out.println("Philosopher " + id + " put down left fork " + leftFork.getId());
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
