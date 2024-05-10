package Assignment1;

public class ShareDataSync {
    private int sharedVariable = 0;

    public synchronized void incrementSynchronized() {
        sharedVariable++;
    }

    public synchronized void decrementSynchronized() {
        sharedVariable--;
    }

    public int getSharedVariable() {
        return sharedVariable;
    }
}
