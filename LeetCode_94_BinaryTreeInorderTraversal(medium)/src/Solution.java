import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        TreeNode t=new TreeNode(1);
        t.right=new TreeNode(2);
        t.right.left=new TreeNode(3);
        List<Integer> result=s.inorderTraversal(t);
        for(Integer i:result){
            System.out.print(i+" ");
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
//        dfs(root,result);
        iteration(root,result);
        return result;
    }

    //recursion
    public void dfs(TreeNode cur,List<Integer> result){
        if(cur.left!=null){
            dfs(cur.left,result);
        }
        result.add(cur.val);
        if(cur.right!=null){
            dfs(cur.right,result);
        }
    }

    //iteration
    public void iteration(TreeNode cur,List<Integer> result){
        LinkedList<TreeNode> ll=new LinkedList<>();
        while(cur!=null || ll.size()!=0){
            if(cur!=null){
                ll.push(cur);
                cur=cur.left;
            }else{
                TreeNode parent=ll.pop();
                result.add(parent.val);
                cur=parent.right;
            }
        }
    }
}