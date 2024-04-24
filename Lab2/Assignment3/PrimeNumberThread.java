package Assignment3;

public class PrimeNumberThread extends Thread {
    private int number;
    private Data data;

    public PrimeNumberThread(Data data, int number) {
        this.number = number;
        this.data = data;
    }

    public void run() {
        for (int i = 1; i <= number; i++) {
            if (checkPrime(i)) {
                data.list.add(i);
            }
        }
    }

    public static boolean checkPrime(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
