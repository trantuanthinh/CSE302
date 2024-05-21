package Assignment1.Synchronized;

public class SharedData {
    private int sharedVariable = 0;

    public synchronized void increment() {
        sharedVariable++;
    }

    public synchronized void decrement() {
        sharedVariable--;
    }

    public int getSharedVariable() {
        return sharedVariable;
    }
}
