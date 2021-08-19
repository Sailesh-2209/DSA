import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final int size = 100;
        List<Integer> list = new ArrayList<>();
        generateRandomIntegerArray(list, size);
        Collections.sort(list);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the search element: ");
        int searchElement = scanner.nextInt();
        scanner.close();
        System.out.printf("%d is found at index: ", searchElement);
        System.out.println(BinarySearch.search(list, searchElement));
    }

    private static void generateRandomIntegerArray(List<Integer> arr, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(random.nextInt(size));
        }
    }
}
