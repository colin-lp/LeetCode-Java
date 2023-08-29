import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode dfs(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft,
                        int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int root = preorder[preorderLeft];
        int inorderRootIndex = indexMap.get(root);

        int leftTreeLength = inorderRootIndex - inorderLeft;
        TreeNode left = dfs(
                preorder,
                inorder,
                preorderLeft + 1,
                preorderLeft + leftTreeLength,
                inorderLeft,
                inorderRootIndex - 1
        );
        TreeNode right = dfs(
                preorder,
                inorder,
                preorderLeft + leftTreeLength + 1,
                preorderRight,
                inorderRootIndex + 1,
                inorderRight
        );
        TreeNode cur = new TreeNode(root, left, right);
        return cur;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return dfs(preorder,
                inorder,
                0,
                preorder.length - 1,
                0,
                inorder.length - 1);
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
