import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //Map<String,Integer> map=new HashMap<>();
        //int r1=dfs(0,maxMove,startRow,startColumn,m,n,map);
        int r2 = dp(m, n, maxMove, startRow, startColumn);
        return r2;
    }

    //dfs+记忆化搜索
    private int dfs(int curMove, int maxMove, int curRow, int curColumn, int m, int n, Map<String, Integer> map) {
        if (curMove > maxMove) {
            return 0;
        }
        if (curRow + 1 > m || curRow < 0 || curColumn + 1 > n || curColumn < 0) {
            return 1;
        }
        String key = curRow + "," + curColumn + "," + curMove;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int rst = 0;
        rst = (rst + dfs(curMove + 1, maxMove, curRow + 1, curColumn, m, n, map)) % 1000000007;
        rst = (rst + dfs(curMove + 1, maxMove, curRow - 1, curColumn, m, n, map)) % 1000000007;
        rst = (rst + dfs(curMove + 1, maxMove, curRow, curColumn + 1, m, n, map)) % 1000000007;
        rst = (rst + dfs(curMove + 1, maxMove, curRow, curColumn - 1, m, n, map)) % 1000000007;
        map.put(key, rst);
        return rst;
    }

    //dp[i][j][k]=移动i步到达(j,k)的方式的数量
    private int dp(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;
        int result = 0;
        for (int i = 0; i < maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[i][j][k];
                    if (j + 1 >= m) {
                        result = (count + result) % 1000000007;
                    } else {
                        dp[i + 1][j + 1][k] = (count + dp[i + 1][j + 1][k]) % 1000000007;
                    }

                    if (j - 1 < 0) {
                        result = (count + result) % 1000000007;
                    } else {
                        dp[i + 1][j - 1][k] = (count + dp[i + 1][j - 1][k]) % 1000000007;
                    }

                    if (k + 1 >= n) {
                        result = (count + result) % 1000000007;
                    } else {
                        dp[i + 1][j][k + 1] = (count + dp[i + 1][j][k + 1]) % 1000000007;
                    }

                    if (k - 1 < 0) {
                        result = (count + result) % 1000000007;
                    } else {
                        dp[i + 1][j][k - 1] = (count + dp[i + 1][j][k - 1]) % 1000000007;
                    }
                }
            }
        }
        return result;
    }
}
