public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        }));
    }

    public int maximalRectangle(char[][] matrix) {
        int y = matrix.length;
        if (y == 0) return 0;
        int x = matrix[0].length;

        int[][] widthArr = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (matrix[i][j] == '0') {
                    widthArr[i][j] = 0;
                    continue;
                }
                if (j == 0) {
                    widthArr[i][j] = 1;
                    continue;
                }
                widthArr[i][j] = widthArr[i][j - 1] + 1;
            }
        }

        int rst = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int width = widthArr[i][j];
                if (width == 0) {
                    continue;
                }
                int temp = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(widthArr[k][j], width);
                    temp = Math.max(temp, (i - k + 1) * width);
                }
                rst = Math.max(rst, temp);
            }
        }
        return rst;
    }
}
