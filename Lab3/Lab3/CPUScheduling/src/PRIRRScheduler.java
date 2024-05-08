import java.util.*;

public class PRIRRScheduler {
    public static void schedule(List<Task> tasks, CPU cpu) {
        tasks.sort(Comparator.comparingInt(Task::getPriority).thenComparing(Task::getName));
        for (Task task : tasks) {
            cpu.executeTask(task);
        }
    }
}
