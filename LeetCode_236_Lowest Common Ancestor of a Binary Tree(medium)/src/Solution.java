public class Solution {
    private TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        Boolean left = dfs(root.left, p, q);
        Boolean right = dfs(root.right, p, q);
        if ((left == right && left == true) 
                || (p.val == root.val && (right || left))
                || (q.val == root.val && (right || left))) {
            result = root;
            return true;
        }
        return left || right || (p.val == root.val || q.val == root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
