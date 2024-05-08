import java.util.*;

public class RRScheduler {
    public static void schedule(Queue<Task> tasks, CPU cpu, int timeQuantum) {
        while (!tasks.isEmpty()) {
            Task task = tasks.poll();
            cpu.executeTask(task);
            if (task.getBurst() > timeQuantum) {
                task.setBurst(task.getBurst() - timeQuantum);
                tasks.offer(task);
            }
        }
    }
}
