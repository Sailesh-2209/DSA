public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode currDummy = dummy;
        int k = lists.length;
        int nullCount = 0;
        if (k == 0)
            return null;
        ListNode[] currList = new ListNode[k];
        for (int i = 0; i < k; i++) {
            currList[i] = lists[i];
        }
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < k; i++) {
                ListNode curr = currList[i];
                if (curr != null && curr.val < min) {
                    min = curr.val;
                    minIndex = i;
                }
            }
            if (min == Integer.MAX_VALUE)
                break;
            currDummy.next = new ListNode(min);
            currDummy = currDummy.next;
            if (currList[minIndex] != null)
                currList[minIndex] = currList[minIndex].next;
            else
                nullCount++;
            if (nullCount == k)
                break;
        }
        return dummy.next;
    }
}
