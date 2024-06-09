public class MemoryBlock {
    int start;
    int size;
    String process;

    MemoryBlock(int start, int size, String process) {
        this.start = start;
        this.size = size;
        this.process = process;
    }

    @Override
    public String toString() {
        return "Addresses [" + start + ":" + (start + size - 1) + "] "
                + (process == null ? "Unused" : "Process " + process);
    }
}
