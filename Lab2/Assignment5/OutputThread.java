package Assignment5;

public class OutputThread extends Thread {
    private Data data;

    public OutputThread(Data data) {
        this.data = data;
    }

    public void run() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int number : data.fiboList) {
            stringBuffer.append(number).append(" ");
        }
        System.out.println("Fibo List: " + stringBuffer);
    }
}
