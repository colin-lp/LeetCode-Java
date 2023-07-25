import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int[] actual = solution.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
        int[] expect = new int[]{8, 12, 6, 10, 10, 10};
        assertArrayEquals(expect, actual);
    }
}