// reversing a linked list

public class Solution {
    public static <T> ListNode<T> reverseList(ListNode<T> head) {
        ListNode<T> prev, next, curr;
        curr = head;
        prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}