import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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

    private List<TreeNode> list;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4)),
                new TreeNode(5,
                        null, new TreeNode(6)));
        Solution s = new Solution();
        s.flatten2(root);
        System.out.println(root);
    }

    // 将左子树替换root右子树，右子树接在左子树的最右节点
    public void flatten1(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode leftRight = root.left;
                while (leftRight.right != null) {
                    leftRight = leftRight.right;
                }
                leftRight.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public void flatten2(TreeNode root) {
        this.list = new ArrayList<>();
        dfs(root);
        TreeNode newRoot = new TreeNode(0);
        for (TreeNode t : list) {
            newRoot.right = t;
            newRoot.left = null;
            newRoot = newRoot.right;
        }
        root = newRoot.right;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        this.list.add(cur);
        dfs(cur.left);
        dfs(cur.right);
    }
}