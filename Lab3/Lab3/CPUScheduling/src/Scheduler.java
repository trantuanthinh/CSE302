import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Scheduler {
    public void simulate() {
        List<Task> tasks = readTasksFromFile("schedule.txt");
        if (tasks.isEmpty()) {
            System.out.println("No tasks found in the file.");
            return;
        }

        CPU cpu = new CPU();

        System.out.println("FCFS Scheduling:");
        FCFSScheduler.schedule(new ArrayList<>(tasks), cpu);

        System.out.println("\nSJF Scheduling:");
        SJFScheduler.schedule(new ArrayList<>(tasks), cpu);

        System.out.println("\nPriority with Round-Robin Scheduling:");
        PRIRRScheduler.schedule(new ArrayList<>(tasks), cpu);

        System.out.println("\nRound-Robin Scheduling:");
        Queue<Task> taskQueue = new ArrayDeque<>(tasks);
        RRScheduler.schedule(taskQueue, cpu, 10);
    }

    private List<Task> readTasksFromFile(String fileName) {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    int priority = Integer.parseInt(parts[1].trim());
                    int burst = Integer.parseInt(parts[2].trim());
                    tasks.add(new Task(name, priority, burst));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading tasks from file: " + e.getMessage());
        }
        return tasks;
    }
}
