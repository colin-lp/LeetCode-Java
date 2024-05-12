import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        long result1 = s.countPairs(3, new int[][]{{0, 1}, {0, 2}, {1, 2}});
        System.out.println(result1 == 0);
        long result2 = s.countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}});
        System.out.println(result2 == 14);
    }

    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }

        boolean[] visited = new boolean[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long count = dfs(i, g, visited);
                total += count * (n - count);
            }
        }
        return total / 2;
    }

    public int dfs(int node, List<Integer>[] g, boolean[] visited) {
        int count = 1;
        visited[node] = true;
        for (int y : g[node]) {
            if (!visited[y]) {
                count += dfs(y, g, visited);
            }
        }
        return count;
    }
}