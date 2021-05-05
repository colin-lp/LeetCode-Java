import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int rst = s.maxSumSubmatrix(new int[][]{{2, 1, 0}}, 3);
        System.out.println(rst);
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] sum = new int[m];
            for (int j = i; j < n; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                int rowSum = 0;
                //可能第一个数就是最接近的，如果set中没有0，则不会替换这个数
                //还有可能k等于m，答案恰好为长度为m的矩形，如果set中没有0，则会找到间距更大的值，而不是长度为k=m的矩形本身
                set.add(0);
                //遍历矩形上边，下边的组合，再对于每个组合，从左往右扫描
                //构建前缀和，加入到有序set，每次查找第一个大于等于
                for (int l = 0; l < m; l++) {
                    sum[l] += matrix[j][l];
                    rowSum += sum[l];
                    // 题目前提：“矩阵内部‘矩形区域’”
                    // 如果在这里add，当k为0，那找出来的数是自己，相当于不选，和为0
                    //set.add(rowSum);
                    Integer ceil = set.ceiling(rowSum - k);
                    if (ceil != null) {
                        rst = Math.max(rst, rowSum - ceil);
                    }
                    set.add(rowSum);
                }
            }
        }
        return rst;
    }
}
