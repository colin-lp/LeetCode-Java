import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.secondMinimum(2, new int[][]{{1, 2}}, 1, 2);
        System.out.println(r);
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int[][] path = new int[n + 1][2];
        for (int[] arr : path) {
            arr[0] = Integer.MAX_VALUE;
            arr[1] = Integer.MAX_VALUE;
        }
        path[1][0] = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        while (path[n][1] == Integer.MAX_VALUE) {
            int[] info = queue.poll();
            int node = info[0];
            int length = info[1] + 1;
            for (int i = 0; i < graph[node].size(); i++) {
                int tempNode = graph[node].get(i);
                if (length < path[tempNode][0]) {
                    int temp = path[tempNode][0];
                    path[tempNode][0] = length;
                    path[tempNode][1] = temp;
                    queue.offer(new int[]{tempNode, length});
                } else if (length > path[tempNode][0] && length < path[tempNode][1]) {
                    path[tempNode][1] = length;
                    queue.offer(new int[]{tempNode, length});
                }
            }
        }

        int rst = 0;
        for (int i = 0; i < path[n][1]; i++) {
            //到达时处于红灯已经亮起，等待变成绿灯的时刻，注意是<=
            if (rst % (2 * change) >= change) {
                rst += (2 * change - rst % (2 * change));
                //error:这样是已经等了红灯的时间
                //rst+=(rst%(2*change)-change);
            }
            rst += time;
        }
        return rst;
    }
}