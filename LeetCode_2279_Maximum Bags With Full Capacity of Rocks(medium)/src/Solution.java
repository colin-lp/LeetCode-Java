import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution() {
        };
        int maximumBags = s.maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2);
        System.out.println(maximumBags);
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int result = 0;
        if (capacity.length == 0) {
            return result;
        }

        int[] left = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            left[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(left);
        int tempRocks = additionalRocks;
        for (int i = 0; i < capacity.length; i++) {
            if ((tempRocks - left[i]) >= 0) {
                tempRocks -= left[i];
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}