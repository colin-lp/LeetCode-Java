import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] arr=new int[]{9,8,7,5,6,3,2,1};
//        s.quickSort(arr,0,7);
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        s.quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> rst = s.threeSum(nums);
        System.out.println(rst);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                while (k > j && nums[j] + nums[k] > -nums[i]) {
                    k--;
                }
                if (k == j) break;
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    rst.add(temp);
                }
            }
        }
        return rst;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int r = (int) (Math.random() * (right - left + 1)) + left;
        swap(nums, r, left);
        int lt = left;
        int i = left + 1;
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

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
