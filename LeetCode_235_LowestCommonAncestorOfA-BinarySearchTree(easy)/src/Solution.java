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

    }

    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = root;
        dfs(root, p, q);
        return result;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (p.val > root.val && q.val < root.val) {
            result = root;
            return;
        }
        if (p.val < root.val && q.val > root.val) {
            result = root;
            return;
        }
        if (q.val < root.val && p.val < root.val) {
            dfs(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            dfs(root.right, p, q);
        } else if (p.val == root.val) {
            result = p;
        } else if (q.val == root.val) {
            result = q;
        }
    }
}