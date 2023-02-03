import java.io.Serial;

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
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t = new TreeNode(0, new TreeNode(0, new TreeNode(0), new TreeNode(0)), null);
        int r = s.minCameraCover(t);
        System.out.println(r);

    }

    public int minCameraCover(TreeNode root) {
        int[] result = dfs(root);
        return result[1];
    }

    public int[] dfs(TreeNode t) {
        if (t == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] l = dfs(t.left);
        int[] r = dfs(t.right);
        int a = l[2] + r[2] + 1;
        int b = Math.min(a, Math.min(l[0] + r[1], l[1] + r[0]));
        int c = Math.min(a, l[1] + r[1]);
        return new int[]{a, b, c};
    }
}
