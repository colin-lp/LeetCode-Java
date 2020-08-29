class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.left.left = null;
        t.left.right = null;
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(7);
        Solution s = new Solution();
        System.out.println(s.isBalanced(t));
    }

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        int irrelevant = dfs(root, 0);
        return result;
    }

    public int dfs(TreeNode cur, int depth) {
        if (cur == null) {
            return depth;
        }
        int l = dfs(cur.left, depth);
        int r = dfs(cur.right, depth);
        if (l - r >= 2 || r - l >= 2) result = false;
        return Math.max(l, r) + 1;
    }
}