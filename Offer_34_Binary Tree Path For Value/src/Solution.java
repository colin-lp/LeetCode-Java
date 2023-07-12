import java.util.*;

public class Solution {
    private List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)
                        ),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1)
                        )
                )
        );
        List<List<Integer>> lists = s.pathSum(t, 22);
        System.out.println(lists.size());
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        Deque<Integer> list = new LinkedList<>();
        dfs(list, root, target);
        return result;
    }

    public void dfs(Deque<Integer> tempList, TreeNode cur, int target) {
        if (cur == null) {
            return;
        }
        tempList.offerLast(cur.val);
        int tempSum = 0;
        for (int i : tempList) {
            tempSum += i;
        }
        if (tempSum == target && cur.left == null && cur.right == null) {
            result.add(new LinkedList<>(tempList));
        }
        dfs(tempList, cur.left, target);
        dfs(tempList, cur.right, target);
        tempList.removeLast();
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
