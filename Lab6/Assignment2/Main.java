import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContiguousMemoryAllocator allocator = null;

        while (true) {
            System.out.print("allocator> ");
            String input = scanner.nextLine();
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "SIZE":
                    int size = Integer.parseInt(commands[1]);
                    allocator = new ContiguousMemoryAllocator(size);
                    break;
                case "RQ":
                    if (allocator == null) {
                        System.out.println("Allocator is not initialized. Please use the SIZE command first.");
                        break;
                    }
                    String process = commands[1];
                    int requestSize = Integer.parseInt(commands[2]);
                    String strategy = commands[3];
                    allocator.requestMemory(process, requestSize, strategy);
                    break;
                case "RL":
                    if (allocator == null) {
                        System.out.println("Allocator is not initialized. Please use the SIZE command first.");
                        break;
                    }
                    String releaseProcess = commands[1];
                    allocator.releaseMemory(releaseProcess);
                    break;
                case "C":
                    if (allocator == null) {
                        System.out.println("Allocator is not initialized. Please use the SIZE command first.");
                        break;
                    }
                    allocator.compactMemory();
                    break;
                case "STAT":
                    if (allocator == null) {
                        System.out.println("Allocator is not initialized. Please use the SIZE command first.");
                        break;
                    }
                    allocator.reportStatus();
                    break;
                case "X":
                    System.out.println("Exiting the allocator.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command: " + commands[0]);
                    break;
            }
        }
    }
}
