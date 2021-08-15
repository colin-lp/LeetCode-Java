import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, new Comparator<int[]>() {
            public int compare(int[] var1, int[] var2) {
                if (var1[0] != var2[0]) {
                    return var1[0] - var2[0];
                } else if (var1[1] != var2[1]) {
                    return var1[1] - var2[1];
                } else {
                    return var1[2] - var2[2];
                }
            }
        });
        int tempCol = Integer.MIN_VALUE;
        List<List<Integer>> rst = new ArrayList<>();
        for (int[] node : nodes) {
            if (node[0] != tempCol) {
                tempCol = node[0];
                List<Integer> list = new ArrayList<>();
                rst.add(list);
            }
            rst.get(rst.size() - 1).add(node[2]);
        }
        return rst;
    }

    private void dfs(TreeNode cur, int row, int col, List<int[]> nodes) {
        if (cur == null) return;
        nodes.add(new int[]{col, row, cur.val});
        dfs(cur.left, row + 1, col - 1, nodes);
        dfs(cur.right, row + 1, col + 1, nodes);
    }
}
