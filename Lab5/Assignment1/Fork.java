package Lab5.Assignment1;

public class Fork {
    private final int id;
    private boolean isTaken;

    public Fork(int id) {
        this.id = id;
        this.isTaken = false;
    }

    public synchronized void take() throws InterruptedException {
        while (isTaken) {
            wait();
        }
        isTaken = true;
    }

    public synchronized void putDown() {
        isTaken = false;
        notifyAll();
    }

    public int getId() {
        return id;
    }
}
