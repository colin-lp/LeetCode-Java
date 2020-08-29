class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        int i = s.rob(t);
        System.out.println(i);
    }

    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode t) {
        if (t == null) return new int[]{0, 0};
        int[] l = dfs(t.left);
        int[] r = dfs(t.right);
        int selected = t.val + l[0] + r[0];
        int unselected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{unselected, selected};
    }
}