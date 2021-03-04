import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(s.lengthOfLIS2(new int[]{4, 10, 4, 3, 8, 9}));
    }

    //dp
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //bs
    public int lengthOfLIS2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                list.set(binarySearch(list, nums[i]), nums[i]);
            }
        }
        return list.size();
    }

    public int binarySearch(List<Integer> list, int num) {
        int low = 0, high = list.size() - 1;
        int mid;
        while (low < high) {
            mid = ((high - low) / 2) + low;
            if (list.get(mid) > num) {
                high = mid;
            } else if (list.get(mid) < num) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
