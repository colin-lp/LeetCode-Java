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

class Solution {
    int l = 0, r = 0;

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean r = s.btreeGameWinningMove(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 3, 1);
        assert (!r);
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        int max = Math.max(n - 1 - l - r, Math.max(l, r));
        if (max <= n) {
            return false;
        }
        return true;
    }

    public int dfs(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        int leftSub = dfs(node.left, x);
        int rightSub = dfs(node.right, x);
        if (node.val == x) {
            l = leftSub;
            r = rightSub;
        }
        return leftSub + rightSub + 1;
    }
}