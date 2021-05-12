public class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int[] sum = new int[max + 1];
        int[] dp = new int[max + 1];
        for (int i : nums) {
            sum[i] += i;
        }
        dp[1] = sum[1];
        dp[2] = Math.max(sum[1], sum[2]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        return dp[max];
    }
}
