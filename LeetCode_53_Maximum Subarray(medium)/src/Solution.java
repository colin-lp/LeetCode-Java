class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int max = 0;
        int result = nums[0];
        for (int num : nums) {
            max = Math.max(max + num, num);
            result = Math.max(max, result);
        }
        return result;
    }
}