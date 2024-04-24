package Assignment3;

public class OutputThread extends Thread {
    private Data data;

    public OutputThread(Data data) {
        this.data = data;
    }

    public void run() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer integer : data.list) {
            stringBuffer.append(integer).append(" ");
        }
        System.out.println("Prime: " + stringBuffer);
    }
}
