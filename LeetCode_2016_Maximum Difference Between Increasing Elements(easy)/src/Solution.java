public class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i : nums) {
            int t = i - min;
            if (t > result) {
                result = t;
            }
            if (i < min) {
                min = i;
            }
        }
        return result == 0 ? -1 : result;
    }
}
