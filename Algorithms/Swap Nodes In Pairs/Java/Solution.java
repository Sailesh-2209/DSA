public class Solution {
    public static ListNode swapPairs(ListNode head) {
        ListNode<Integer> dummy = new ListNode<>(0);
        dummy.next = head;
        ListNode<Integer> curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
