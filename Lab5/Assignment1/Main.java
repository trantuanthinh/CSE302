package Lab5.Assignment1;

public class Main {

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[5];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % forks.length]);
            new Thread(philosophers[i]).start();
        }
    }
}
