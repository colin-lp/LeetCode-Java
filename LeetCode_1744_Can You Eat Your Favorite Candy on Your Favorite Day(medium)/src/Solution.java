public class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] pre = new long[candiesCount.length + 1];
        boolean[] rst = new boolean[queries.length];
        pre[0] = 0;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            long x1 = queries[i][1] + 1;
            long y1 = (long) (queries[i][1] + 1) * queries[i][2];
            long x2 = queries[i][0] == 0 ? 1 : pre[queries[i][0]] + 1;
            long y2 = pre[queries[i][0] + 1];
            //是否有交集
            rst[i] = !(y1 < x2 || x1 > y2);
        }
        return rst;
    }
}
