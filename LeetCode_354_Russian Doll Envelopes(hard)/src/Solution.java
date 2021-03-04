import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        for (int i = 0; i < envelopes.length; i++) {
            if (envelopes[i][1] > list.get(list.size() - 1)) {
                list.add(envelopes[i][1]);
            } else {
                list.set(binarySearch(list, envelopes[i][1]), envelopes[i][1]);
            }
        }
        return list.size();
    }

    public int binarySearch(List<Integer> list, int num) {
        int low = 0, high = list.size() - 1;
        int mid;
        while (low < high) {
            mid = ((high - low) / 2) + low;
            if (list.get(mid) > num) {
                high = mid;
            } else if (list.get(mid) < num) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
