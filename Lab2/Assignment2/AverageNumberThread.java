package Assignment2;

import java.util.List;

public class AverageNumberThread extends Thread {
    private List<Integer> listOfNumbers;
    private Data data;

    public AverageNumberThread(List<Integer> listOfNumbers, Data data) {
        this.listOfNumbers = listOfNumbers;
        this.data = data;
    }

    public void run() {
        int total = 0;
        for (Integer integer : listOfNumbers) {
            total += integer;
        }
        this.data.average = total / listOfNumbers.size();
    }
}
