import java.util.Random;

public class Solution {
    private static final Random random = new Random();

    public static void main(String[] args) {
        final int size = 10;
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        generateRandomIntegerLL(sll, size);
        System.out.println(sll);
    }

    private static void generateRandomIntegerLL(SinglyLinkedList<Integer> sll, int size) {
        for (int i = 0; i < size; i++) {
            sll.append(random.nextInt(size));
        }
    }
}
