public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.right=new TreeNode(4);
        t.right.right=new TreeNode(5);
        System.out.println(s.isCousins(t,4,5));
    }
    int xD, yD;
    TreeNode xP, yP;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return (xD == yD && xP != yP);
    }

    private void dfs(TreeNode t, TreeNode p, int depth, int x, int y) {
        if (t == null) return;
        if (t.val == x) {
            xD = depth;
            xP = p;
        } else if (t.val == y) {
            yD = depth;
            yP = p;
        }
        dfs(t.left, t, depth + 1, x, y);
        dfs(t.right, t, depth + 1, x, y);
    }
}

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
