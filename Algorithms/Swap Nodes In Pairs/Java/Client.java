import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        int seed = random.nextInt(10);
        ListNode<Integer> head = new ListNode<>(seed);
        ListNode<Integer> curr = head;
        for (int i = 0; i < seed; i++) {
            ListNode<Integer> newNode = new ListNode<>(random.nextInt(seed * 10));
            curr.next = newNode;
            curr = curr.next;
        }
        curr = head;
        System.out.println("Linked List Data: ");
        while (curr != null) {
            System.out.printf("%d ", curr.val);
            curr = curr.next;
        }
        System.out.println();
        System.out.println("Pair Wise Reversed Linked List: ");
        ListNode<Integer> reverseHead = Solution.swapPairs(head);
        while (reverseHead != null) {
            System.out.printf("%d ", reverseHead.val);
            reverseHead = reverseHead.next;
        }
    }
}
