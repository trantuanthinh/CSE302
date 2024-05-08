import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Task> queue = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("schedule.txt"));

        String line = br.readLine();

        while (line != null) {
            String[] comps = line.split(",\\s*");
            Task task = new Task(comps[0], Integer.parseInt(comps[1]), Integer.parseInt(comps[2]));
            queue.add(task);

            line = br.readLine();
        }

        br.close();

        Scheduler scheduler = new Scheduler();
        scheduler.simulate();
    }
}
