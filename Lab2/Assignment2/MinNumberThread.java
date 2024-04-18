package Assignment2;

import java.util.List;

public class MinNumberThread extends Thread {
    private List<Integer> listOfNumbers;
    private Data data;

    public MinNumberThread(List<Integer> listOfNumbers, Data data) {
        this.listOfNumbers = listOfNumbers;
        this.data = data;
    }

    public void run() {
        for (Integer integer : listOfNumbers) {
            if (integer < this.data.min) {
                this.data.min = integer;
            }
        }
    }
}
