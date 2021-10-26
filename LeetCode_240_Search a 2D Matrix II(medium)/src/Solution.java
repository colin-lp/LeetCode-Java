public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;
        int n = matrix.length, m = matrix[0].length;
        while (x < n && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
