import java.util.Arrays;

public class Solution {
    public int search(int[] nums, int target) {
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i;
                break;
            }
        }
        Arrays.sort(nums);
        int res = search(nums, 0, nums.length - 1, target);
        int index = k > res ? k - res : res - k;
        return index;
    }

    private int search(int[] nums, int lo, int hi, int val) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == val)
            return mid;
        else if (nums[mid] > val)
            return search(nums, 0, mid - 1, val);
        else
            return search(nums, mid + 1, hi, val);
    }
}
