public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        int min = Integer.MAX_VALUE, max = 0;
        for (int i : bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int mid;
        while (min < max) {
            mid = (max - min) / 2 + min;
            if (validate(bloomDay, mid, m, k)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean validate(int[] bloomDay, int day, int m, int k) {
        boolean rst = false;
        int continuation = 0;
        int count = 0;
        for (int i : bloomDay) {
            if (i <= day) {
                continuation++;
                if (continuation == k) {
                    count++;
                    continuation = 0;
                }
            } else {
                //[7,7,7,7,12,7,7]
                //7天：[x, x, x, x, _, x, x]
                //断开连续时需要清零，不做累加
                continuation = 0;
            }
        }
        return count >= m;
    }
}
