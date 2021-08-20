import java.util.EmptyStackException;

public class DoublyLinkedList<T> {
    private Node head, tail;
    private int size;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(T data) {
        this.head = new Node(data);
        tail = head;
    }

    public void append(T data) {
        if (head == null) {
            head = tail = new Node(data);
        } else {
            tail.next = new Node(data, null, tail);
            tail = tail.next;
        }
        size++;
    }

    public void insert(int pos, T data) {
        if (pos < 0 || pos > this.size)
            throw new IndexOutOfBoundsException();
        if (pos == 0)
            insertAtHead(data);
        else if (pos == this.size)
            append(data);
        else {
            Node curr = head;
            for (int i = 0; i < pos - 1; i++)
                curr = curr.next;
            Node newNode = new Node(data, curr.next, curr);
            curr.next.prev = newNode;
            curr.next = newNode;
            size++;
            return;
        }
    }

    private void insertAtHead(T data) {
        Node newNode = new Node(data, head, null);
        newNode.prev = head;
        head = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        T data = tail.data;
        tail = tail.prev;
        --size;
        if (isEmpty())
            head = null;
        else
            tail.next = null;
        return data;
    }

    public T remove(int pos) {
        if (isEmpty())
            throw new RuntimeException("Empty List");
        if (pos < 0 || pos >= this.size)
            throw new IndexOutOfBoundsException();
        if (pos == this.size - 1)
            return pop();
        if (pos == 0)
            return removeHead();
        Node curr = head;
        for (int i = 0; i < pos - 1; i++)
            curr = curr.next;
        Node remove = curr.next;
        curr.next.next.prev = curr;
        curr.next = curr.next.next;
        remove.next = null;
        remove.prev = null;
        --size;
        if (isEmpty())
            head = null;
        return remove.data;
    }

    private T removeHead() {
        T data = head.data;
        head = head.next;
        head.prev = null;
        --size;
        if (isEmpty())
            head = null;
        return data;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        if (head == null)
            return "[]";
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (curr.next != null) {
            sb.append(curr.data).append(", ");
            curr = curr.next;
        }
        sb.append(curr.data).append("]");
        return sb.toString();
    }

    private class Node {
        T data;
        Node next, prev;

        private Node(T data) {
            this.data = data;
        }

        private Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}