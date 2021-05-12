public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.minimumTimeRequired(new int[]{3,2,3},3));
    }
    public int minimumTimeRequired(int[] jobs, int k) {
        int max = 0;
        int sum = 0;
        for (int i : jobs) {
            sum += i;
            max = Math.max(max, i);
        }
        int left = max, right = sum, mid;
        // 从大到小排序完2ms 没排序4ms
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (check(jobs, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] jobs, int k, int max) {
        int[] loads = new int[k];
        return dfs(jobs, loads, max, 0);
    }

    private boolean dfs(int[] jobs, int[] loads, int max, int i) {
        if (i >= jobs.length) {
            return true;
        }
        int value = jobs[i];
        for (int j = 0; j < loads.length; j++) {
            if (loads[j] + value <= max) {
                loads[j] += value;
                if (dfs(jobs, loads, max, i + 1)) {
                    return true;
                }
                loads[j] -= value;
            }

            //没分配 或 刚好达到max限制，说明max值<=结果，结束验证。
            if (loads[j] == 0 || loads[j] + value == max) {
                break;
            }
        }
        return false;
    }
}
