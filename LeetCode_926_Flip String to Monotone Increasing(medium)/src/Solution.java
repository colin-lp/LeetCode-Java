public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.minFlipsMonoIncr("100000001010000");
        System.out.println(r);
    }

    public int minFlipsMonoIncr(String s) {
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int newdp0 = dp0, newdp1 = Math.min(dp0, dp1);
            if (c == '1') {
                newdp0++;
            } else {
                newdp1++;
            }
            dp0 = newdp0;
            dp1 = newdp1;
        }
        return Math.min(dp0, dp1);
        // return dfs(0, 0, s.length(), 0, s);
    }

    // 超时
    public int dfs(int pre, int index, int len, int flip, String s) {
        if (index == len) {
            return flip;
        }
        if (pre == 0) {
            if (s.charAt(index) == '0') {
                int notFlipNumber = dfs(0, index + 1, len, flip, s);
                int flipNumber = dfs(1, index + 1, len, flip + 1, s);
                return Math.min(notFlipNumber, flipNumber);
            } else {
                int notFlipNumber = dfs(1, index + 1, len, flip, s);
                int flipNumber = dfs(0, index + 1, len, flip + 1, s);
                return Math.min(notFlipNumber, flipNumber);
            }
        } else {
            if (s.charAt(index) == '1') {
                int notFlipNumber = dfs(1, index + 1, len, flip, s);
                return notFlipNumber;
            } else {
                int flipNumber = dfs(1, index + 1, len, flip + 1, s);
                return flipNumber;
            }
        }
    }
}
