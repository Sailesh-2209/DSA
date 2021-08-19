import java.util.List;

public class BinarySearch {
    public static int search(List<Integer> arr, int num) {
        return search(arr, 0, arr.size() - 1, num);
    }

    private static int search(List<Integer> arr, int lo, int hi, int val) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr.get(mid) == val)
            return mid;
        else if (arr.get(mid) > val)
            return search(arr, 0, mid - 1, val);
        else
            return search(arr, mid + 1, hi, val);
    }
}