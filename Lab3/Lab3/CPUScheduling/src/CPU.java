public class CPU {
    public void executeTask(Task task) {
        System.out.println("Executing Task " + task.getName() + " with priority " + task.getPriority() + " and burst " + task.getBurst() + " milliseconds.");
        
        int remainingBurst = task.getBurst();
        while (remainingBurst > 0) {
            int quantum = Math.min(remainingBurst, 10);
            remainingBurst -= quantum;
            System.out.println("Processing " + quantum + " milliseconds...");

            try {
                Thread.sleep(quantum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Task " + task.getName() + " completed.");
    }
}
