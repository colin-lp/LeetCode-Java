public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 2) return s;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int maxL = 0, max = 1;
        for (int length = 2; length <= len; length++) {
            for (int l = 0; l < len; l++) {
                int r = length - 1 + l;
                if (r >= len) {
                    break;
                }
                if (chars[l] == chars[r]) {
                    if ((r - l) < 3) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                } else {
                    dp[l][r] = false;
                }

                if (dp[l][r] && max < (r - l + 1)) {
                    max = r - l + 1;
                    maxL = l;
                }
            }
        }
        return s.substring(maxL, maxL + max);
    }
}