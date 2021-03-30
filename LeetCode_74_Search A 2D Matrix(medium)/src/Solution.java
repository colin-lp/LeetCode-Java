
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean rst=s.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);
        System.out.println(rst);
    }
    int row;
    public boolean searchMatrix(int[][] matrix, int target) {
        Integer rst = binarySearch(target, matrix, 0);
        if (rst == null) {
            rst = binarySearch(target, matrix, 1);
            if (rst == null) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private Integer binarySearch(int target, int[][] matrix, int orient) {
        if (orient == 0) {
            int left = 0, right = matrix.length - 1, middle;
            while (left <= right) {
                middle = (right - left) / 2 + left;
                if (matrix[middle][0] < target) {
                    left = middle + 1;
                } else if (matrix[middle][0] > target) {
                    right = middle - 1;
                } else {
                    return matrix[middle][0];
                }
            }
            row = left == 0 ? 0 : left - 1;
            return null;
        } else {
            int left = 0, right = matrix[0].length - 1, middle;
            while (left <= right) {
                middle = (right - left) / 2 + left;
                if (matrix[row][middle] < target) {
                    left = middle + 1;
                } else if (matrix[row][middle] > target) {
                    right = middle - 1;
                } else {
                    return matrix[row][middle];
                }
            }
            return null;
        }
    }
}