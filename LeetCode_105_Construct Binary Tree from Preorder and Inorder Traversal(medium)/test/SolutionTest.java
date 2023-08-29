import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        TreeNode buildTree = s.buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}
        );
        //root
        assertEquals(buildTree.val, 3);

        //left subtree
        assertEquals(buildTree.left.val, 9);
        assertNull(buildTree.left.left);
        assertNull(buildTree.left.right);

        //right subtree
        assertEquals(buildTree.right.val, 20);
        assertEquals(buildTree.right.left.val, 15);
        assertNull(buildTree.right.left.left);
        assertNull(buildTree.right.left.right);
        assertEquals(buildTree.right.right.val, 7);
        assertNull(buildTree.right.right.left);
        assertNull(buildTree.right.right.right);
    }
}
