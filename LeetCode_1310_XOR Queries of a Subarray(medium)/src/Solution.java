public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            // a xor a=0 对应位置抵消了，所以可以用前缀和思想。
            ans[i] = prefix[queries[i][0]] ^ prefix[queries[i][1] + 1];
        }
        return ans;
    }
}