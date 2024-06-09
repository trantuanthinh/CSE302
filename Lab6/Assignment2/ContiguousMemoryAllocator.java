import java.util.ArrayList;
import java.util.List;

public class ContiguousMemoryAllocator {
    private List<MemoryBlock> memoryBlocks;
    private int totalSize;

    public ContiguousMemoryAllocator(int size) {
        this.totalSize = size;
        this.memoryBlocks = new ArrayList<>();
        this.memoryBlocks.add(new MemoryBlock(0, size, null));
    }

    public void requestMemory(String process, int size, String strategy) {
        int index = -1;
        switch (strategy) {
            case "F": // First Fit
                index = findFirstFit(size);
                break;
            case "B": // Best Fit
                index = findBestFit(size);
                break;
            case "W": // Worst Fit
                index = findWorstFit(size);
                break;
            default:
                System.out.println("Unknown strategy: " + strategy);
                return;
        }

        if (index == -1) {
            System.out.println("Unable to allocate memory for process " + process);
            return;
        }

        MemoryBlock block = memoryBlocks.get(index);
        if (block.size > size) {
            memoryBlocks.add(index + 1, new MemoryBlock(block.start + size, block.size - size, null));
        }
        block.size = size;
        block.process = process;
    }

    private int findFirstFit(int size) {
        for (int i = 0; i < memoryBlocks.size(); i++) {
            if (memoryBlocks.get(i).process == null && memoryBlocks.get(i).size >= size) {
                return i;
            }
        }
        return -1;
    }

    private int findBestFit(int size) {
        int bestFitIndex = -1;
        int smallestSize = Integer.MAX_VALUE;
        for (int i = 0; i < memoryBlocks.size(); i++) {
            if (memoryBlocks.get(i).process == null && memoryBlocks.get(i).size >= size
                    && memoryBlocks.get(i).size < smallestSize) {
                smallestSize = memoryBlocks.get(i).size;
                bestFitIndex = i;
            }
        }
        return bestFitIndex;
    }

    private int findWorstFit(int size) {
        int worstFitIndex = -1;
        int largestSize = -1;
        for (int i = 0; i < memoryBlocks.size(); i++) {
            if (memoryBlocks.get(i).process == null && memoryBlocks.get(i).size >= size
                    && memoryBlocks.get(i).size > largestSize) {
                largestSize = memoryBlocks.get(i).size;
                worstFitIndex = i;
            }
        }
        return worstFitIndex;
    }

    public void releaseMemory(String process) {
        for (MemoryBlock block : memoryBlocks) {
            if (process.equals(block.process)) {
                block.process = null;
                return;
            }
        }
        System.out.println("Process " + process + " not found.");
    }

    public void compactMemory() {
        int freeStart = 0;
        List<MemoryBlock> newMemoryBlocks = new ArrayList<>();
        for (MemoryBlock block : memoryBlocks) {
            if (block.process != null) {
                newMemoryBlocks.add(new MemoryBlock(freeStart, block.size, block.process));
                freeStart += block.size;
            }
        }
        if (freeStart < totalSize) {
            newMemoryBlocks.add(new MemoryBlock(freeStart, totalSize - freeStart, null));
        }
        memoryBlocks = newMemoryBlocks;
    }

    public void reportStatus() {
        for (MemoryBlock block : memoryBlocks) {
            System.out.println(block);
        }
    }
}
