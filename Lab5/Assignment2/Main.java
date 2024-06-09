package Lab5.Assignment2;

public class Main {
    public static void main(String[] args) {
        int totalChopsticks = 5;
        DiningPhilosophers dp = new DiningPhilosophers(totalChopsticks);

        Runnable philosopher = new Runnable() {
            @Override
            public void run() {
                int philosopherId = Integer.parseInt(Thread.currentThread().getName());

                while (true) {
                    if (dp.requestChopstick(philosopherId)) {
                        if (dp.requestChopstick(philosopherId)) {
                            System.out.println("Philosopher " + philosopherId + " is eating.");
                            dp.releaseChopstick(philosopherId);
                            dp.releaseChopstick(philosopherId);
                            break;
                        } else {
                            dp.releaseChopstick(philosopherId);
                        }
                    }

                    try {
                        Thread.sleep((int) (Math.random() * 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(philosopher, String.valueOf(i)).start();
        }
    }
}
