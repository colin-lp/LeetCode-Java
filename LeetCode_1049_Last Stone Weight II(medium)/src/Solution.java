import java.util.Arrays;

public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int[] dp = new int[(sum / 2) + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = dp.length - 1; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        //总数分成两堆，(a<=b)，则最终差值为
        //b = sum - a
        //b - a = sum - a - a = sum - a * 2
        return sum - dp[dp.length - 1] * 2;
    }
}
