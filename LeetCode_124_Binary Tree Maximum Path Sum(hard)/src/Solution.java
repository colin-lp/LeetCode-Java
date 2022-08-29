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

    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        System.out.println(s.maxPathSum(t));
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        if ((node.val + left + right) > max) {
            max = node.val + left + right;
        }
        return Math.max(left, right) + node.val;
    }
}
