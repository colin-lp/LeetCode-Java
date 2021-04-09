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
        Solution s=new Solution();
        TreeNode t=new TreeNode(Integer.MIN_VALUE);
//        t.right=new TreeNode(Long.MIN_VALUE);
        System.out.println(s.isValidBST(t));
//        System.out.println(Long.MIN_VALUE);
    }

    boolean b=true;
    long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return b;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if(node.val<=pre){
            b=false;
            return;
        }
        pre=node.val;
        dfs(node.right);
    }
}
