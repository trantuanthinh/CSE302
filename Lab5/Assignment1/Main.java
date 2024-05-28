package Assignment1;

public class Main {
    public static void main(String[] args) {
        WaterMonitor monitor = new WaterMonitor();

        Runnable hydrogenTask = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " Hydrogen thread ...");
                monitor.hydrogen();
                System.out.println(Thread.currentThread().getName() + " Hydrogen thread completed.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable oxygenTask = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " Oxygen thread ...");
                monitor.oxygen();
                System.out.println(Thread.currentThread().getName() + " Oxygen thread completed.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread[] threads = new Thread[6];
        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(hydrogenTask, "H" + (i + 1));
        }
        for (int i = 4; i < 6; i++) {
            threads[i] = new Thread(oxygenTask, "O" + (i - 3));
        }

        for (Thread t : threads) {
            t.start();
        }
        System.out.println("Water: " + monitor.getWater());
    }
}
