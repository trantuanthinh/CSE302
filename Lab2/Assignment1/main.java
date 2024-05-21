package Assignment1;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData1 = new SharedData();

        IncreasedThread in1 = new IncreasedThread(sharedData1);
        DecreasedThread de1 = new DecreasedThread(sharedData1);
        in1.start();
        try {
            in1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        de1.start();
        try {
            de1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("a/ Final value of the variable: " + sharedData1.variable);

        SharedData sharedData2 = new SharedData();

        IncreasedThread in2 = new IncreasedThread(sharedData2);
        DecreasedThread de2 = new DecreasedThread(sharedData2);
        in2.start();
        de2.start();

        try {
            in2.join();
            de2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("b/ Final value of the variable: " + sharedData2.variable);
    }
}
