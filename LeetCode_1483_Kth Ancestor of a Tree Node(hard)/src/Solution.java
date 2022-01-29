class TreeAncestor {
    int[][] parents;

    public TreeAncestor(int n, int[] parent) {
        int length = (int) Math.floor(Math.log(n) / Math.log(2));
        parents = new int[n][length + 1];
        for (int i = 0; i < parent.length; i++) {
            parents[i][0] = parent[i];
        }
        for (int i = 1; i < parents[0].length; i++) {
            for (int j = 0; j < n; j++) {
                if (parents[j][i - 1] == -1) {
                    parents[j][i] = -1;
                } else {
                    parents[j][i] = parents[parents[j][i - 1]][i - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int pos = 0;

        while (k > 0 && node != -1) {
            if ((k & 1) == 1) {
                node = parents[node][pos];
            }
            k >>= 1;
            pos++;
        }
        return node;
    }
}

public class Solution {

    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        //treeAncestor.getKthAncestor(3, 1);   返回 1 ，它是 3 的父节点
        //treeAncestor.getKthAncestor(5, 2);   返回 0 ，它是 5 的祖父节点
        //treeAncestor.getKthAncestor(6, 3);   返回 -1 因为不存在满足要求的祖先节点
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
