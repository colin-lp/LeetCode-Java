import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList1 = new ArrayList<>();
        subList1.add(15);
        subList1.add(96);
        list.add(subList1);
        List<Integer> subList2 = new ArrayList<>();
        subList2.add(36);
        subList2.add(2);
        list.add(subList2);
        int result = s.connectTwoGroups(list);
        System.out.println(result);
        System.out.println(Math.min(2147483644, Integer.MAX_VALUE));
    }

    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size();
        int size2 = cost.get(0).size();
        int combinationSize = 1 << size2;
        int[][] dp = new int[size1 + 1][combinationSize];
        for (int i = 0; i < size1 + 1; i++) {
            // 参与运算，最大值溢出
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        //只能置00为0
        dp[0][0] = 0;
        // dp[i][j] 前i-1个和j个点的最小成本
        for (int i = 1; i < size1 + 1; i++) {
            // 遍历bitmap的所有组合
            for (int j = 0; j < combinationSize; j++) {
                for (int k = 0; k < size2; k++) {
                    if ((j & (1 << k)) == 0) {
                        continue;
                    }

                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + cost.get(i - 1).get(k));
                    dp[i][j] = Math.min(dp[i][j], dp[i][j ^ (1 << k)] + cost.get(i - 1).get(k));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j ^ (1 << k)] + cost.get(i - 1).get(k));
                }
            }
        }
        return dp[size1][combinationSize - 1];
    }
}
