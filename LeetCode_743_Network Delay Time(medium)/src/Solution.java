import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        Map<Integer, Integer> distance = new HashMap<>();
        //根节点到达所有节点的路径表
        for (int i = 1; i <= n; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(k, 0);
        boolean[] visited = new boolean[n + 1];
        while (true) {
            int candidateNode = -1;
            int candidateDistance = Integer.MAX_VALUE;
            //找到可达节点中路径最短的
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && distance.get(i) < candidateDistance) {
                    candidateNode = i;
                    candidateDistance = distance.get(i);
                }
            }
            //没有可达节点，跳出
            if (candidateNode < 0) break;
            //根到该节点路径一定最短
            visited[candidateNode] = true;
            //去到这个目前最短节点作为临时节点，找到他的所有邻接，将这些节点路径更新为 {已知最短路径，通过临时节点到达路径} 中最短的路径
            if (graph.containsKey(candidateNode)) {
                //从邻接表中找到这个节点所对应的信息
                for (int[] info : graph.get(candidateNode)) {
                    distance.put(
                            info[0],
                            Math.min(
                                    distance.get(info[0]),
                                    distance.get(candidateNode) + info[1]
                            )
                    );
                }
            }
        }
        int ans = 0;
        for (int i : distance.values()) {
            if (i == Integer.MAX_VALUE) return -1;
            //所有的节点都需要收到信号(最远)
            ans = Math.max(i, ans);
        }
        return ans;
    }

    public int networkDelayTimeOfHeap(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        //根可以到达的节点
        Map<Integer, Integer> distance = new HashMap<>();
        //小顶堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (info1, info2) -> info1[0] - info2[0]
        );
        heap.offer(new int[]{0, k});
        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int nodeDistance = info[0], node = info[1];
            //已经存储的最短路径节点，过滤其他更长的
            if (distance.containsKey(node)) continue;
            //这样的话，存储的一定是到达该节点的最短路径
            distance.put(node, nodeDistance);
            //取到邻接表中该节点对应的信息
            if (graph.containsKey(node)) {
                for (int[] tempInfo : graph.get(node)) {
                    int tempNode = tempInfo[0], tempNodeDistance = tempInfo[1];
                    //distance中存的一定是根据堆顶，已经选择的节点最短路径，如果这个临时节点也能到已存的节点，那路径必然更长
                    if (!distance.containsKey(tempNode)) {
                        heap.offer(new int[]{tempNodeDistance + nodeDistance, tempNode});
                    }
                }
            }
        }
        //没有找出根到达每一个节点的路径，存在不可达节点
        if (distance.size() != n) return -1;
        int ans = 0;
        for (int i : distance.values()) {
            //所有的节点都需要收到信号(最远)
            ans = Math.max(i, ans);
        }
        return ans;
    }
}
