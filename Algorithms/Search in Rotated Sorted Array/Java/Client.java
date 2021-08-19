import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Random random = new Random();
        int size = random.nextInt(10);
        int[] numArr = new int[size];
        int target = random.nextInt(size - 1);
        for (int i = 0; i < size; i++) {
            numArr[i] = random.nextInt(size * 10);
        }
        int result = solution.search(numArr, target);
    }
}
