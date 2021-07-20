public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int rst = s.minPairSum(new int[]{3, 5, 2, 3});
        System.out.println(rst);
    }

    public int minPairSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            rst = Math.max(nums[i] + nums[nums.length - 1 - i], rst);
        }
        return rst;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int v = (int) (Math.random() * (right - left)) + left;
        swap(nums, v, left);
        int lt = left;
        int i = lt + 1;
        int gt = right + 1;
        while (i < gt) {
            if (nums[i] < nums[left]) {
                swap(nums, i, lt + 1);
                lt++;
                i++;
            } else if (nums[i] > nums[left]) {
                swap(nums, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(nums, left, lt);
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt, right);
    }

    private void swap(int nums[], int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
