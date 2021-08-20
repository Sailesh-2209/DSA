import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Client {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int size = random.nextInt(10);
        ListNode[] lists = new ListNode[size];
        for (int i = 0; i < size; i++) {
            lists[i] = generateRandomLinkedList(size);
        }
        System.out.println();
        System.out.println("The sorted linked lists are: ");
        System.out.println();
        for (int i = 0; i < size; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                System.out.printf("%d -> ", curr.val);
                curr = curr.next;
            }
            System.out.println();
        }
        ListNode resultHead = Solution.mergeKLists(lists);
        List<Integer> resultArray = new ArrayList<>();
        ListNode curr = resultHead;
        System.out.println("The single sorted linked list is: ");
        while (curr != null) {
            resultArray.add(curr.val);
            curr = curr.next;
        }
        System.out.println(resultArray);
    }

    private static ListNode generateRandomLinkedList(int size) {
        int length = random.nextInt(size);
        List<Integer> arr = generateRandomIntegerArray(length);
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int i = 0; i < length; i++) {
            curr.next = new ListNode(arr.get(i));
            curr = curr.next;
        }
        return dummyHead.next;
    }

    private static List<Integer> generateRandomIntegerArray(int size) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(random.nextInt(size * 10));
        }
        Collections.sort(arr);
        return arr;
    }
}
