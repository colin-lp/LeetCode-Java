import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.List;

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
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(6);
        s.flatten(t);
        System.out.println(1);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> l = new ArrayList();

        dfs(root, l);
        for (int i = 1; i < l.size(); i++) {
            root.right = l.get(i);
            root.left = null;
            root = root.right;
        }
    }

    public void dfs(TreeNode t, List<TreeNode> l) {
        l.add(t);
        if (t.left != null) dfs(t.left, l);
        if (t.right != null) dfs(t.right, l);
    }

}