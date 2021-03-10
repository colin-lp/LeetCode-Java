import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCut("aab"));
    }

    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                dp[left][right] = s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1]);
            }
        }
        int min = Integer.MAX_VALUE;
        int[] rst = new int[len];
        Arrays.fill(rst,min);
        for (int i = 0; i < len; i++) {
            if (dp[0][i]) {
                rst[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if(dp[j+1][i]){
                        rst[i]=Math.min(rst[i],rst[j]+1);
                    }
                }
            }
        }
        return rst[len-1];
    }
}
