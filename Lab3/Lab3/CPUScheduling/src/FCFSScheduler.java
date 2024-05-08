import java.util.*;

public class FCFSScheduler {
    public static void schedule(List<Task> tasks, CPU cpu) {
        for (Task task : tasks) {
            cpu.executeTask(task);
        }
    }
}
