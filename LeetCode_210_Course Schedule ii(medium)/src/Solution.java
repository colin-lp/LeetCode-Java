import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] in = new int[numCourses];
        for (int[] arr : prerequisites) {
            if (map.containsKey(arr[1])) {
                List<Integer> list = map.get(arr[1]);
                list.add(arr[0]);
                in[arr[0]]++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[0]);
                map.put(arr[1], list);
                in[arr[0]]++;
            }
        }
        Deque<Integer> q = new LinkedList<>();
        int[] rst = new int[numCourses];
        int rstIndex = 0;
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.offerFirst(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            rst[rstIndex++] = i;
            if (map.containsKey(i)) {
                List<Integer> tempList = map.get(i);
                for (Integer inte : tempList) {
                    in[inte]--;
                    if (in[inte] == 0) {
                        q.offerLast(inte);
                    }
                }
            } else {
                continue;
            }
        }
        for (int inte : in) {
            if (inte != 0) {
                return new int[0];
            }
        }
        return rst;
    }
}
