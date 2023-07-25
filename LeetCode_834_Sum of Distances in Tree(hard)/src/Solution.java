import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[] ans;
    private int[] size;
    private List<List<Integer>> graph;

    public static void main(String[] args) {
        Solution s = new Solution();
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        size = new int[n];
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] x : edges) {
            if (null == graph.get(x[0])) {
                graph.add(x[0], new ArrayList<>());
            }
            if (null == graph.get(x[1])) {
                graph.add(x[1], new ArrayList<>());
            }
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        dfs(0, -1, 0);
        calc(0, -1);
        return ans;
    }

    private void dfs(int cur, int parent, int depth) {
        ans[0] += depth;
        size[cur] = 1;
        List<Integer> y = graph.get(cur);
        for (Integer v : y) {
            if (v == parent) {
                continue;
            }
            dfs(v, cur, depth + 1);
            size[cur] += size[v];
        }
    }

    private void calc(int cur, int parent) {
        List<Integer> y = graph.get(cur);
        for (Integer v : y) {
            if (v == parent) {
                continue;
            }
            ans[v] += ans[cur] + graph.size() - 2 * size[v];
            calc(v, cur);
        }
    }
}