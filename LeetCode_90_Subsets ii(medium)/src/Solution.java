import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> rst = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        dfs(0, nums.length, nums, false);
        return rst;
    }

    public void dfs(int cur, int len, int[] nums, boolean choosePre) {
        if (cur == len) {
            rst.add(new ArrayList(tmp));
            return;
        }

        dfs(cur + 1, len, nums, false);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        tmp.add(nums[cur]);
        dfs(cur + 1, len, nums, true);
        tmp.remove(tmp.size() - 1);
    }

    public void quickSort(int left, int right, int[] nums) {
        if (left > right) return;
        int temp = (int) (Math.random() * (right - left)) + left;
        int lt = left, gt = right + 1, i = left + 1;

        swap(left, temp, nums);
        while (i < gt) {
            if (nums[i] < nums[left]) {
                swap(i, lt + 1, nums);
                lt++;
                i++;
            } else if (nums[i] > nums[left]) {
                swap(i, gt - 1, nums);
                gt--;
            } else {
                i++;
            }
        }
        swap(lt, left, nums);
        quickSort(left, lt - 1, nums);
        quickSort(gt, right, nums);
    }

    public void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
