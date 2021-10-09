import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class SummaryRanges {

        List<int[]> list = new ArrayList<>();

        public SummaryRanges() {
            //题目设定：0 <= val <= 10^4
            list.add(new int[]{-10, -10});
            list.add(new int[]{10010, 10010});
        }

        public void addNum(int val) {
            int left = 0, right = list.size() - 1;
            while (left < right) {
                //+1：因为有哨兵头元素
                int mid = (right - left + 1) / 2 + left;
                //0 [-10,-10] [1,1] [3,3] 因为有头哨兵，所以下面的add是在right+1
                if (list.get(mid)[0] <= val) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            int[] cur = new int[]{val, val};
            int[] prev = list.get(right);
            int[] next = list.get(right + 1);
            if ((prev[0] <= val && prev[1] >= val) || (next[0] <= val && next[1] >= val)) {

            } else if (val == prev[1] + 1 && val == next[0] - 1) {
                prev[1] = next[1];
                list.remove(right + 1);
            } else if (prev[1] + 1 == val) {
                prev[1] = val;
            } else if (next[0] - 1 == val) {
                next[0] = val;
            } else {
                list.add(right + 1, cur);
            }
        }

        public int[][] getIntervals() {
            int[][] rst = new int[list.size() - 2][2];
            for (int i = 1; i < list.size() - 1; i++) {
                int[] tmp = list.get(i);
                rst[i - 1][0] = tmp[0];
                rst[i - 1][1] = tmp[1];
            }
            return rst;
        }
    }
}
