import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++)
            sll.append(random.nextInt(100));
        System.out.println(sll);
    }
}