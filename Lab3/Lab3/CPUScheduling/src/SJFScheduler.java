import java.util.*;

public class SJFScheduler {
    public static void schedule(List<Task> tasks, CPU cpu) {
        tasks.sort(Comparator.comparingInt(Task::getBurst));
        for (Task task : tasks) {
            cpu.executeTask(task);
        }
    }
}
