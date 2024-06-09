package Lab6.Assignment1;

public class Main {

    public static void main(String[] args) {
        int virtualAddress = 19986;

        int pageSize = 1024 * 4;
        int pageSizeBits = 12;

        int pageNumber = virtualAddress >> pageSizeBits;
        int offset = virtualAddress & (pageSize - 1);

        System.out.println("The address " + virtualAddress + " contains:");
        System.out.println("Page number = " + pageNumber);
        System.out.println("Offset = " + offset);
    }
}
