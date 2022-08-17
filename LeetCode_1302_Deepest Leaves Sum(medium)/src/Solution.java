package src;

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
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.left.left.left = new TreeNode(7);
        t.right = new TreeNode(3);
        t.right.right = new TreeNode(6);
        t.right.right.right = new TreeNode(8);
        Solution s = new Solution();
        System.out.println(s.deepestLeavesSum(t));
    }

    int max = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        TreeNode r = root;
        dfs(r, 0);
        return sum;
    }

    public void dfs(TreeNode cur, int depth) {
        if (cur == null) {
            if (depth > max) {
                max = depth - 1;
            }
            return;
        }
        if (depth == max) {
            sum += cur.val;
        } else if (depth > max) {
            sum = cur.val;
        }
        dfs(cur.left, depth + 1);
        dfs(cur.right, depth + 1);
    }
}