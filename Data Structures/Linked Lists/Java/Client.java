// this is for testing the linked lists

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        // Testing singly linked list
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++)
            sll.append(random.nextInt(100));
        System.out.println(sll);
        // Testing doubly linked list
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            dll.append(random.nextInt(100));
        }
        System.out.println(dll);
    }
}