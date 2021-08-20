// Structure of a singly linked list node

public class ListNode<T> {
    T val;
    ListNode<T> next;

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }
}