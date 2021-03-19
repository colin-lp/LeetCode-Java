import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][t.length()] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    //leetcode 41 / 62 overtime
    List<Character> temp = new ArrayList<>();
    int rst = 0;

    private void dfs(int index, String s, String t) {
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : temp) {
                sb.append(c);
            }
            if (sb.toString().equals(t)) {
                rst++;
            }
            return;
        }
        temp.add(s.charAt(index));
        dfs(index + 1, s, t);
        temp.remove(temp.size() - 1);
        dfs(index + 1, s, t);
    }
}
