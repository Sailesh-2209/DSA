public class SinglyLinkedList<T extends Comparable<T>> {

    private Node head;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T data) {
        head = new Node(data);
    }

    public void append(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = new Node(data);
        }
    }

    public void insert(T data, int index) {
        if (index == 0) {
            Node dummyHead = new Node(data);
            dummyHead.next = head;
            head = dummyHead;
        } else if (index == size()) {
            append(data);
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else {
            int p = 0;
            Node curr = head;
            while (curr != null) {
                p++;
                if (index == p)
                    break;
                curr = curr.next;
            }
            Node newNode = new Node(data);
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    public T remove(int index) {
        if (index == 0) {
            return removeHead();
        } else if (index == size() - 1) {
            return removeTail();
        } else if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            int p = 0;
            Node curr = head;
            while (curr.next != null) {
                p++;
                if (index == p)
                    break;
                curr = curr.next;
            }
            T temp = curr.next.data;
            curr.next = curr.next.next;
            return temp;
        }
    }

    public T removeHead() {
        if (head == null)
            throw new RuntimeException("Cannot remove head of empty list");
        T data = head.data;
        head = head.next;
        return data;
    }

    public T removeTail() {
        Node curr = head;
        while (curr.next.next != null)
            curr = curr.next;
        T data = curr.next.data;
        curr.next = null;
        return data;
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            Node curr = head;
            sb.append("[");
            for (int i = 0; i < size() - 1; i++) {
                sb.append(curr.data).append(", ");
                curr = curr.next;
            }
            sb.append(curr.data).append("]");
            return sb.toString();
        }
    }

    public int size() {
        Node curr = head;
        int N = 0;
        while (curr != null) {
            curr = curr.next;
            N++;
        }
        return N;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class Node {

        private T data;
        private Node next;

        private Node() {
        }

        private Node(T data) {
            this.data = data;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}