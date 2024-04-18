package Assignment2;

import java.util.List;

public class MaxNumberThread extends Thread {
    private List<Integer> listOfNumbers;
    private Data data;

    public MaxNumberThread(List<Integer> listOfNumbers, Data data) {
        this.listOfNumbers = listOfNumbers;
        this.data = data;
    }

    public void run() {
        for (Integer integer : listOfNumbers) {
            if (integer > this.data.max) {
                this.data.max = integer;
            }
        }
    }
}
